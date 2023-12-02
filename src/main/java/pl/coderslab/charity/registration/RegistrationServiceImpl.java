package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.email.EmailService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserService;

import java.time.LocalDate;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final EmailService emailService;

    public String saveAndSendActivationLink(User user, String password) {
        String uuid = UUID.randomUUID().toString().toUpperCase().replace("-", "");
        userService.userDataToSave(user, password, uuid);
        userService.save(user);
        emailService.sendActivationEmail(user.getEmail(), uuid);
        return "redirect:/login";
    }

    public String accountActivation(String uuid){
        User user = userService.getUserByUuid(uuid);
        if (user == null) {
            return "redirect:/";
        } else if (user.getUuIdExpirationDate().isBefore(LocalDate.now())) {
            return "redirect:/";
        } else {
            user.setActive(true);
            userService.save(user);
            return "redirect:/login";
        }
    }
}
