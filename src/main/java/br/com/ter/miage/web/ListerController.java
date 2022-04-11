package br.com.ter.miage.web;


import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListerController {

    @Autowired
    PatientService patientService;

    @GetMapping("/lister")
    public String showListerPage(Model model) {
        List<Patient> patientList = patientService.getAllPatients();

        model.addAttribute("patientList", patientList);
        return "lister";
    }

    @GetMapping("deletePatient")
    public String deleteAPatient(Model model, @RequestParam("patientId") Long patientId) {
        patientService.deletePatientById(patientId);

        return "redirect:/lister?deleteSuccess";
    }



}
