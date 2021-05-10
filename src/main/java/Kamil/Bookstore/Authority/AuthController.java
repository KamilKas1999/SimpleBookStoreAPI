package Kamil.Bookstore.Authority;

import Kamil.Bookstore.Authority.request.SignIn;
import Kamil.Bookstore.Authority.request.SignUp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody SignUp signupRequest) throws ParseException {
        authService.signup(signupRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/signin")
    public ResponseEntity<AuthenticationDTO> signin(@RequestBody SignIn signinRequest) {
        return new ResponseEntity<>(authService.login(signinRequest), HttpStatus.OK);
    }
}
