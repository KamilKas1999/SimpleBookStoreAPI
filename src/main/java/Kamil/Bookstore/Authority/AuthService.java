package Kamil.Bookstore.Authority;

import Kamil.Bookstore.Authority.request.SignIn;
import Kamil.Bookstore.Authority.request.SignUp;
import Kamil.Bookstore.Model.User;
import Kamil.Bookstore.Repository.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.util.Base64;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public void signup(SignUp request) throws ParseException {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new IllegalArgumentException();
        User user = User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        userRepository.save(user);
    }

    public AuthenticationDTO login(SignIn request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> {
            throw new IllegalArgumentException();
        });
        return AuthenticationDTO.builder()
                .user(UserDTO.builder().id(user.getId()).email(user.getEmail()).build())
                .token(Base64.getEncoder().encodeToString((request.getEmail() + ':' + request.getPassword()).getBytes(StandardCharsets.UTF_8)))
                .build();
    }

    @Transactional
    public User getCurrentUser() {
        UserPrincipal principal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

}
