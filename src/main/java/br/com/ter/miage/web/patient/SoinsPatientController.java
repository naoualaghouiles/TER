package br.com.ter.miage.web.patient;

import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.entities.Dossier_Soins;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.services.interfaces.SoinsService;
import br.com.ter.miage.services.interfaces.DossierSoinsService;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class SoinsPatientController {

    @Autowired
    SoinsService soinsService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierSoinsService dossierSoinsService;

    @GetMapping("/soins-patient")
    public String showSoinsPatient(Model model) {
        List<Soins> soinsList = soinsService.getAllSoins();

        model.addAttribute("soinsList", soinsList);

        return "soins-patient";
    }

    @GetMapping("/mes-soins")
    public String showMySoins(Model model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            List<Soins> soinsList = dossierSoinsService.getPatientSoins(patient);
            model.addAttribute("soinsList", soinsList);
        }
        return "mes-soins";
    }

    @GetMapping("/addSoins/{id}")
    public String addSoinsPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            if (dossierSoinsService.existsBy(patient, soinsService.getSoins(id))) {
                return "redirect:/soins-patient?exists";
            }
            Dossier_Soins dossierSoins = dossierSoinsService.ajouter(patient, soinsService.getSoins(id));
            if (dossierSoins != null) {
                return "redirect:/soins-patient?success";
            } else {
                return "redirect:/soins-patient?error";
            }
        }
    }

    @GetMapping("/deleteSoins/{id}")
    public String deleteSoinsPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            dossierSoinsService.deleteDossierSoins(patient, soinsService.getSoins(id));
            return "redirect:/mes-soins?delete";

        }
    }
}
