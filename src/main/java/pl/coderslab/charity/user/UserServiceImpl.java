package pl.coderslab.charity.user;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;


    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public User getUserByUuid(String uuid) {
        return userRepository.getUserByUuId(uuid);
    }

    @Override
    public User userDataToSave(User user, String password, String uuid) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setUuId(uuid);
//        //TODO: strefa czasowa w application.properties
        user.setUuIdExpirationDate(LocalDate.now(ZoneId.of("Europe/Warsaw")).plusDays(1));
        return new User();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
