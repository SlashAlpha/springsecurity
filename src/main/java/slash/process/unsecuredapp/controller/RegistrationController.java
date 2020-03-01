package slash.process.unsecuredapp.controller;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import slash.process.unsecuredapp.model.User;
import slash.process.unsecuredapp.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String register() {
        return "registration/index";
    }

    @PostMapping("/register")
    public String registerUser(@Valid User user) {
        User user1 = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()), "USER", "");
        userRepository.save(user1);
        return "index";
    }


}
