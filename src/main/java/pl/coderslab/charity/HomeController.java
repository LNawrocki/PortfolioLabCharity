package pl.coderslab.charity;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.donation.DonationService;
import pl.coderslab.charity.institution.InstitutionService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.UUID;


@Controller
@AllArgsConstructor
public class HomeController {

    private final InstitutionService institutionService;
    private final DonationService donationService;
//    private final EmailService emailService;

    @GetMapping("/")
    public String homeView(Model model){
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("bags", donationService.findAll().stream().count());
        model.addAttribute("gifts", donationService.numberOfGifts());

        return "home";
    }
}
