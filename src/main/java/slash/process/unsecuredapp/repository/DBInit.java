package slash.process.unsecuredapp.repository;


import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import slash.process.unsecuredapp.model.User;

import java.util.Arrays;
import java.util.List;

@Service
public class DBInit implements CommandLineRunner {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        //Delete all
        this.userRepository.deleteAll();

        User dan = new User("dan", passwordEncoder.encode("dan123"), "USER", "");
        User admin = new User("admin", passwordEncoder.encode("admin"), "ADMIN", "ACCESS_API");
        User manager = new User("manager", passwordEncoder.encode("manager"), "MANAGER", "ACCESS_API");

        List<User> users = Arrays.asList(dan, admin, manager);

        userRepository.saveAll(users);
    }

}
