package slash.process.unsecuredapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import slash.process.unsecuredapp.model.User;
import slash.process.unsecuredapp.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    UserRepository userRepository;

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(s);
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
