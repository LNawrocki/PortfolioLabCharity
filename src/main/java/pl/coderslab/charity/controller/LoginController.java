package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.entity.User;
import pl.coderslab.charity.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@AllArgsConstructor
@SessionAttributes({"msg"})
public class LoginController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

//    private final UserService userService;
//
//    @GetMapping("/login")
//    public String loginView(Model model, HttpSession session) {
//        model.addAttribute("msg", session.getAttribute("msg"));
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        Model model) {
//
//        if (Optional.of(userService.getUserByEmail(username)).isPresent()) {
//            User userByEmail = userService.getUserByEmail(username);
//             if (BCrypt.checkpw(password, userByEmail.getPassword())){
//                 return "user-home";
//             }
//        }
//        model.addAttribute("msg", "Błąd logowania, spróbuj ponownie");
//        return "/login";
//    }
}
