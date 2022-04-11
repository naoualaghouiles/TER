package br.com.ter.miage.web.patient;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.services.interfaces.ActivityService;
import br.com.ter.miage.services.interfaces.DossierActivityService;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ActivitiesPatientController {

    @Autowired
    ActivityService activityService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierActivityService dossierActivityService;

    @GetMapping("/activities-patient")
    public String showActivityPatient(Model model) {
        List<Activity> activityList = activityService.getAllActivities();

        model.addAttribute("activityList", activityList);

        return "activities-patient";
    }

    @GetMapping("/mes-activities")
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
            List<Activity> activityList = dossierActivityService.getPatientActivity(patient);
            model.addAttribute("activityList", activityList);
        }
        return "mes-activities";
    }

    @GetMapping("/addActivity/{id}")
    public String addActivityPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            if (dossierActivityService.existsBy(patient, activityService.getActivity(id))) {
                return "redirect:/activities-patient?exists";
            }
            Dossier_Activity dossierActivity = dossierActivityService.ajouter(patient, activityService.getActivity(id));
            if (dossierActivity != null) {
                return "redirect:/activities-patient?success";
            } else {
                return "redirect:/activities-patient?error";
            }
        }
    }

    @GetMapping("/deleteActivity/{id}")
    public String deleteActivityPatient(@PathVariable Long id) {
        Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Patient patient = null;
        if (object instanceof Patient) {
            patient = (Patient) object;
            patient = patientService.getPatientById(patient.getIdPatient());
        }
        if (patient == null) {
            return "redirect:/login";
        } else {
            dossierActivityService.deleteDossierActivity(patient, activityService.getActivity(id));
            return "redirect:/mes-activities?delete";

        }
    }
}
