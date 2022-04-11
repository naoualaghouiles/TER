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
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class ModifierController {

    @Autowired
    PatientService patientService;


    @GetMapping("/modifierPatient")
    public String showAjoutPatientForm(Model model, @RequestParam("patientId") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        AjoutPatientDto ajoutPatientDto = new AjoutPatientDto(
                patientId,
                patient.getNom(),
                patient.getPrenom(),
                patient.getEmail(),
                patient.getAdresse(),
                patient.getNumTel(),
                patient.getSexe(),
                simpleDateFormat.format(patient.getDateNaissance()),
                simpleDateFormat.format(patient.getDateEntree()),
                patient.getGir().getIdGir()

        );

        model.addAttribute("patient", ajoutPatientDto);
        return "modifierPatient";
    }


    @ModelAttribute("patient")
    public AjoutPatientDto patientAddDto() {
        return new AjoutPatientDto();
    }

    @PostMapping("/modifierPatient")
    public String addPatientPost(@ModelAttribute("patient") AjoutPatientDto ajoutPatientDto) {
        try {
            patientService.modifierPatient(ajoutPatientDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierPatient?invalid";
        }


        return "redirect:/lister?modifieSuccess";

    }
}
