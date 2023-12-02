package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;

    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("bags", donationService.numberOfBags());
        model.addAttribute("donations", donationService.numberOfDonations());
        return "home";
    }
}
