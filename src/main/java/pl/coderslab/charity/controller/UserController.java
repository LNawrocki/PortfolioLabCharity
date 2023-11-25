package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.UserService;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
    private final CategoryService categoryService;
    private final UserService userService;

    //TODO : pobranie nazwy użytkownika

    @GetMapping("/home")
    public String userHome(Model model, Principal principal){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("bags", donationService.findAll().stream().count());
        model.addAttribute("gifts", donationService.numberOfGifts());


        model.addAttribute("username", principal.getName());
        return "user-home";
    }

    @GetMapping("/form")
    public String formView(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        return "form";
    }
}
