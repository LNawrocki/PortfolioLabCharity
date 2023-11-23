package pl.coderslab.charity.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.repository.UserRepository;

import javax.validation.Valid;

@Controller

public class RegisterController {

    private final UserRepository userService;
    private final PasswordEncoder passwordEncoder;

    public RegisterController(UserRepository userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerView(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String processRegistrationForm(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/register";
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");
        user.setActive(true);
        userService.save(user);
        return "redirect:/login";
    }


//    @PostMapping("/register")
//    public String register(@Valid User user, BindingResult bindingResult,
//                           @RequestParam String password,
//                           @RequestParam String password2, Model model){
//
//        if (bindingResult.hasErrors()){
//            return "register";
//        }
//        if (password.equals(password2)){
//            //TODO - sprawdzenie czy użytkownik istnieje
//            user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
//            userService.save(user);
//            return "redirect:/login";
//        }
//        model.addAttribute("msg", "Hasła muszą być takie same");
//        return "register";
//    }
}
