package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@SessionAttributes({"msg"})
public class LoginController {

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }
}
