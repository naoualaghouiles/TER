package br.com.ter.miage.web.patient;

import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.entities.Dossier_Prestation;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.services.interfaces.PrestationService;
import br.com.ter.miage.services.interfaces.DossierPrestationService;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PrestationsPatientController {

    @Autowired
    PrestationService prestationService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierPrestationService dossierPrestationService;

    @GetMapping("/prestations-patient")
    public String showPrestationPatient(Model model) {
        List<Prestation> prestationList = prestationService.getAllPrestations();

        model.addAttribute("prestationList", prestationList);

        return "prestations-patient";
    }

    @GetMapping("/mes-prestations")
    public String showMyActivities(Model model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            List<Prestation> prestationList = dossierPrestationService.getPatientPrestation(patient);
            model.addAttribute("prestationList", prestationList);
        }
        return "mes-prestations";
    }

    @GetMapping("/addPrestation/{id}")
    public String addPrestationPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            if (dossierPrestationService.existsBy(patient, prestationService.getPrestation(id))) {
                return "redirect:/prestations-patient?exists";
            }
            Dossier_Prestation dossierPrestation = dossierPrestationService.ajouter(patient, prestationService.getPrestation(id));
            if (dossierPrestation != null) {
                return "redirect:/prestations-patient?success";
            } else {
                return "redirect:/prestations-patient?error";
            }
        }
    }

    @GetMapping("/deletePrestation/{id}")
    public String deletePrestationPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            dossierPrestationService.deleteDossierPrestation(patient, prestationService.getPrestation(id));
            return "redirect:/mes-prestations?delete";

        }
    }
}
