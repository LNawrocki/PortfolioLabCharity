package pl.coderslab.charity.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserRepository;

import java.util.Set;

@Service
@AllArgsConstructor
public class AuthService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("No username " + email + " found");
        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), user.getActive(), true, true, true,
                Set.of(new SimpleGrantedAuthority(user.getRole())));
    }
}
