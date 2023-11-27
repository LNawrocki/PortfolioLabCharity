package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.email.EmailDetails;
import pl.coderslab.charity.email.EmailService;
import pl.coderslab.charity.user.User;
import pl.coderslab.charity.user.UserRepository;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;

import static com.fasterxml.jackson.databind.type.LogicalType.DateTime;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final UserRepository userService;
    private final EmailService emailService;


    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

//    @PostMapping("/register")
//    public String processRegistrationForm(@Valid User user, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "/register";
//        }
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setRole("USER");
//        user.setActive(true);
//        userService.save(user);
//        return "redirect:/login";
//    }


    @PostMapping("/register")
    public String register(@Valid User user, BindingResult bindingResult,
                           @RequestParam String password,
                           @RequestParam String password2,
                           EmailDetails emailDetails,
                           Model model){

//        System.out.println(bindingResult);
        if (bindingResult.hasErrors()){
            return "register";
        }
        if (userService.getUserByEmail(user.getEmail()) != null) {
            model.addAttribute("msg", "Użytkownik o podanym adresie e-mail już istnieje");
            return "register";
        }
        if (password.equals(password2)){
            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
            String UuId = UUID.randomUUID().toString().toUpperCase().replace("-","");
            user.setUuId(UuId);
            user.setUuIdExpirationDate(LocalDate.now(ZoneId.of("Europe/Warsaw")).plusDays(1));
            userService.save(user);
            emailDetails.setSubject("Activation link");
            emailDetails.setRecipient(user.getEmail());
            String link = "http://localhost8080/register/activation?UuId=" + UuId;
            emailDetails.setMsgBody(link);
//            emailService.sendSimpleMail(emailDetails);
            return "redirect:/login";
        }
        model.addAttribute("msg", "Hasła muszą być takie same");
        return "register";
    }

    @GetMapping("/register/activation")
    public String activation(@RequestParam(value = "UuId") String UuId){
        User user = userService.getUserByUuId(UuId);
        if(user == null) {
            return "redirect:/";
        } else {
            user.setActive(true);
            userService.save(user);
            return "redirect:/login";
        }

    }
}
