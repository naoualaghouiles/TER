package br.com.ter.miage.web.patient;

import br.com.ter.miage.entities.Dossier_Repas;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.entities.Repas;
import br.com.ter.miage.services.interfaces.DossierRepasService;
import br.com.ter.miage.services.interfaces.PatientService;
import br.com.ter.miage.services.interfaces.RepasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RepasPatientController {

    @Autowired
    RepasService repasService;

    @Autowired
    DossierRepasService dossierRepasService;

    @Autowired
    PatientService patientService;

    @GetMapping("/repas-patient")
    public String showRepasPatient(Model model) {
        List<Repas> repasList = repasService.getAllRepas();

        model.addAttribute("repasList", repasList);

        return "repas-patient";
    }

    @GetMapping("/mes-repas")
    public String showMesRepasPatient(Model model) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            List<Repas> repasList = dossierRepasService.getPatientRepas(patient);
            model.addAttribute("repasList", repasList);
        }
        return "mes-repas";
    }

    @GetMapping("/addRepas/{id}")
    public String addRepasPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            if (dossierRepasService.existsBy(patient, repasService.getRepasById(id))) {
                return "redirect:/repas-patient?exists";
            }
            Dossier_Repas dossierRepas = dossierRepasService.ajouter(patient, repasService.getRepasById(id));
            if (dossierRepas != null) {
                return "redirect:/repas-patient?success";
            } else {
                return "redirect:/repas-patient?error";
            }
        }
    }

    @GetMapping("/deleteRepas/{id}")
    public String deleteRepasPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            dossierRepasService.deleteDossierRepas(patient, repasService.getRepasById(id));
            return "redirect:/mes-repas?delete";

        }
    }

    @GetMapping("/supprimeRepas/{id}")
    public String deleteRepas(@PathVariable Long id) {
        repasService.deleteRepas(id);
        return "redirect:/repas?delete";
    }
}
