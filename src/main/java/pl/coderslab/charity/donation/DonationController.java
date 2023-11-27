package pl.coderslab.charity.donation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.category.CategoryService;
import pl.coderslab.charity.institution.InstitutionService;


@Controller
@AllArgsConstructor
public class DonationController {

    private final DonationService donationService;
    private final CategoryService categoryService;
    private final InstitutionService institutionService;



    @GetMapping("/donation")
    public String donationView (Model model){
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation")
    public String donation (Donation donation){
        //TODO - zrobić podsumowanie w ostatnim kroku formularza weryfikacja daty aktualna lub przyszła
        donationService.save(donation);
        return "form-confirmation";
    }


}
