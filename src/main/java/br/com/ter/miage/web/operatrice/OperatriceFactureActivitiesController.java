package br.com.ter.miage.web.operatrice;

import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LigneActivity;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
public class OperatriceFactureActivitiesController {

    @Autowired
    LigneActivityService ligneActivityService;

    @Autowired
    ActivityService activityService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierActivityService dossierActivityService;

    @Autowired
    FactureService factureService;

    @GetMapping("/facture-activities")
    public String factureActivities(Model model, @RequestParam("patientId") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return "redirect:/error";
        } else {
            List<Activity> activityList = dossierActivityService.getPatientActivity(patient);
            model.addAttribute("activityList", activityList);
            model.addAttribute("patient", patient);
        }

        return "facture-activities";
    }
    
    @GetMapping("/addActivityFacture/{idActivity}")
    public String addActivityFacture(Model model, @PathVariable Long idActivity, @RequestParam("patientId") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return "redirect:/error";
        } else {
            Set<Facture> factureSet = patient.getFactures();

            Facture facturePatientCeMois = null;

            for (Facture facture :
                    factureSet) {
                Date date = facture.getDateF();

                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                Calendar calToday = Calendar.getInstance();
                calToday.setTime(new Date());

                if ((calToday.get(Calendar.MONTH) == month) && (calToday.get(Calendar.YEAR) == year)) {
                    facturePatientCeMois = facture;
                }
            }

            if (facturePatientCeMois == null) {
                Facture facture = new Facture("Provisoire", new Date(), patient);
                facturePatientCeMois = factureService.ajouterFacture(facture);
            }

            Activity activity = activityService.getActivity(idActivity);



            if (ligneActivityService.existsBy(activity, facturePatientCeMois)) {
                return "redirect:/facture-activities?patientId="+patient.getIdPatient()+"&exists";
            } else {
                LigneActivity ligneActivity = new LigneActivity(activity, facturePatientCeMois);
                ligneActivityService.ajouterLigneAcitivy(ligneActivity);
                return "redirect:/facture-activities?patientId="+patient.getIdPatient()+"&success";
            }



        }
    }
}
