package pl.coderslab.charity.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;

import java.security.Principal;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/home")
    public String adminHome(Model model, Principal principal){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("bags", donationService.numberOfBags());
        model.addAttribute("donations", donationService.numberOfDonations());
        model.addAttribute("username", principal.getName());
        return "admin-home";
    }
}
