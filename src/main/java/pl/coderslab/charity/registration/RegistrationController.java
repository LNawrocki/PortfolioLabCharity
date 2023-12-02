package pl.coderslab.charity.registration;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.email.EmailDetails;
import pl.coderslab.charity.email.EmailService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserService;

import javax.validation.Valid;
import java.time.LocalDate;


@Controller
@AllArgsConstructor
public class RegistrationController {

    private final UserService userService;
    private final EmailService emailService;
    private final RegistrationService registrationService;


    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult,
                           @RequestParam String password,
                           @RequestParam String password2,
                           EmailDetails emailDetails,
                           Model model) {

        if (bindingResult.hasErrors()) {
            return "register";
        }
        if (userService.getUserByEmail(user.getEmail()) != null) {
            model.addAttribute("msg", "Użytkownik o podanym adresie e-mail już istnieje");
            return "register";
        }
        if (password.equals(password2)) {
            registrationService.saveAndSendActivationLink(user, password);
            return "redirect:/login";
        }
        model.addAttribute("msg", "Hasła muszą być takie same");
        return "register";
    }

    @GetMapping("/register/activation")
    public String activation(@RequestParam(value = "uuid") String uuid) {
        return registrationService.accountActivation(uuid);
   }
}

