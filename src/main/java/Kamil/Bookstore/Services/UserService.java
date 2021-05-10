package Kamil.Bookstore.Services;

import Kamil.Bookstore.Model.User;
import Kamil.Bookstore.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User updatedUser){
        updatedUser.setId(id);
        return userRepository.save(updatedUser);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
