package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/home")
    public String adminHome(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("bags", donationService.findAll().stream().count());
        model.addAttribute("gifts", donationService.numberOfGifts());
        model.addAttribute("username", ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());
        return "admin-home";
    }
}
