package br.com.ter.miage.web.operatrice;

import br.com.ter.miage.dto.AdminDto;
import br.com.ter.miage.dto.SearchPatientDto;
import br.com.ter.miage.entities.*;
import br.com.ter.miage.services.interfaces.DossierActivityService;
import br.com.ter.miage.services.interfaces.FactureService;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class OperatricePatientsController {

    @Autowired
    FactureService factureService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierActivityService dossierActivityService;

    @GetMapping("/operatrice-patients")
    public String showOpPage(Model model, @RequestParam("search") Optional<String> search) {
        List<Patient> patientList = null;
        if (search.isPresent()) {
            patientList = patientService.searchForPatients(search.get());
        } else {
            patientList = patientService.getAllPatients();
        }

        model.addAttribute("patientList", patientList);
        return "operatrice-patients";
    }

//    @GetMapping("/operatrice-patients")
//    public String showOpPageFiltered(Model model, ) {
//        List<Patient> patientList = patientService.searchForPatients(search);
//
//        model.addAttribute("patientList", patientList);
//        return "operatrice-patients";
//    }

    @GetMapping("facture-patient")
    public String facturePatient(Model model, @RequestParam("patientId") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return "redirect:/error";
        } else {
            factureService.updatePrixFactures(patient);

            Set<Facture> factureList = patient.getFactures();

            model.addAttribute("factureList", factureList);
            model.addAttribute("patient", patient);
        }

        return "facture-patient";
    }

    @ModelAttribute("searchDto")
    public SearchPatientDto searchPatientDto() {
        return new SearchPatientDto();
    }




    @PostMapping("/search")
    public String showFilteredPatients(Model model, @ModelAttribute SearchPatientDto searchPatientDto) {

        return "redirect:/operatrice-patients?search=" + searchPatientDto.getPatientName();
    }


}
