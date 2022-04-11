package br.com.ter.miage.web;

import br.com.ter.miage.dto.PatientDto;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class RegistrationController {

    @Autowired
    PatientService patientService;

    @ModelAttribute("patient")
    public PatientDto patientRegistrationDto() {
        return new PatientDto();
    }



//        @PostMapping("/inscription")
//    public String registerAdmin(@ModelAttribute PatientDto  patientDto) {
//        patientService.saveUser(patientDto);
//        return "redirect:/registration?success";
//    }
//
//
    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }
}
