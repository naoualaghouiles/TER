package br.com.ter.miage.web;


import br.com.ter.miage.dto.AjoutPatientDto;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutPatientController {

    @Autowired
    PatientService patientService;

    @GetMapping("/ajoutPatient")
    public String showAjoutPatientForm(Model model) {
        return "ajoutPatient";
    }

    @ModelAttribute("patient")
    public AjoutPatientDto patientAddDto() {
        return new AjoutPatientDto();
    }

    @PostMapping("/ajoutPatient")
    public String addPatientPost(@ModelAttribute("patient") AjoutPatientDto ajoutPatientDto) {
        Patient patient = patientService.addPatient(ajoutPatientDto);

        if (patient != null) {
            return "redirect:/lister?success";
        } else {
            return "redirect:/ajoutPatient?invalid";
        }
    }
}
