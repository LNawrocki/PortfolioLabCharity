package pl.coderslab.charity.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;
import pl.coderslab.charity.entity.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class InstitutionController {

    private final InstitutionService institutionService;


    @GetMapping("/institution")
    public String institutionView(Model model) {
        model.addAttribute("institutions", institutionService.findAll());
        model.addAttribute("institution", new Institution());
        return "admin-institution";
    }

    @PostMapping("/institution")
    public String institution(Institution institution) {
        institutionService.save(institution);
        return "redirect:/admin/institution";
    }

    @PostMapping("/institution/add")
    public String addInstitution( Institution institution, Model model) {
            institutionService.save(institution);
            model.addAttribute("institutions", institutionService.findAll());
            model.addAttribute("institution", new Institution());
            return "redirect:/admin/home#help";
//        }
    }

//    TODO: brak edycji instytucji i usuiwania gdy są zależności z darami

//    @PostMapping("/institution/edit")
//    public ModelAndView editInstitution(@RequestParam(required = false) Integer institutionId, Model model) {
//
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setView(new InternalResourceView("/WEB-INF/views/admin-home.jsp#help"));
//
//        Institution institutionById = institutionService.getById(institutionId);
//        model.addAttribute("institutions", institutionService.findAll());
//        model.addAttribute("institutionById", institutionById);
//        return modelAndView;
//    }

    @PostMapping("/institution/delete")
    public String deleteInstitution(@RequestParam Integer institutionId) {
            institutionService.delete(institutionId);
            return "redirect:/admin/home#help";
    }
}
