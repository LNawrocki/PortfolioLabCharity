package pl.coderslab.charity.institution;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.charity.donation.Donation;
import pl.coderslab.charity.donation.DonationService;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class InstitutionController {

    private final InstitutionService institutionService;
    private final DonationService donationService;


    @PostMapping("/institution/add")
    public String addInstitution(Institution institution, Model model) {
        institutionService.save(institution);
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("institution", new Institution());
        return "redirect:/admin/home#help";
    }


    @GetMapping("/institution/edit")
    public String editInstitutionView(@RequestParam Integer institutionId, Model model) {

        Institution institution = institutionService.getById(institutionId);
        model.addAttribute("institution", institution);
        return "edit-institution";
    }

    @PostMapping("/institution/edit")
    public String editInstitution(Institution institution) {
        Institution institution1 = institutionService.get(institution.getId());
        institution1.setName(institution.getName());
        institution1.setDescription(institution.getDescription());
        institutionService.save(institution1);
        return "redirect:/admin/home#help";
    }

    @PostMapping("/institution/delete")
    public String deleteInstitution(@RequestParam Integer institutionId) {
        List<Donation> donationsByInstitutionId = donationService.findDonationsByInstitution_Id(institutionId);
        if (!donationsByInstitutionId.isEmpty()) {
            for (Donation donation : donationsByInstitutionId) {
                donationService.deleteDonation(donation);
            }
        } else {
            institutionService.delete(institutionId);
        }
        return "redirect:/admin/home#help";
    }
}
