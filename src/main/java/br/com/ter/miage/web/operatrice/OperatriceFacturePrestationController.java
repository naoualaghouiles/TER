package br.com.ter.miage.web.operatrice;

import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LignePrestation;
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
public class OperatriceFacturePrestationController {

    @Autowired
    LignePrestationService lignePrestationService;

    @Autowired
    PrestationService prestationService;

    @Autowired
    PatientService patientService;

    @Autowired
    DossierPrestationService dossierPrestationService;

    @Autowired
    FactureService factureService;

    @GetMapping("/facture-prestations")
    public String factureActivities(Model model, @RequestParam("patientId") Long patientId) {
        Patient patient = patientService.getPatientById(patientId);

        if (patient == null) {
            return "redirect:/error";
        } else {
            List<Prestation> prestationList = dossierPrestationService.getPatientPrestation(patient);
            model.addAttribute("prestationList", prestationList);
            model.addAttribute("patient", patient);
        }

        return "facture-prestations";
    }
    
    @GetMapping("/addPrestationFacture/{idPrestation}")
    public String addPrestationFacture(Model model, @PathVariable Long idPrestation, @RequestParam("patientId") Long patientId) {
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

            Prestation prestation = prestationService.getPrestation(idPrestation);



            if (lignePrestationService.existsBy(prestation, facturePatientCeMois)) {
                return "redirect:/facture-prestations?patientId="+patient.getIdPatient()+"&exists";
            } else {
                LignePrestation lignePrestation = new LignePrestation(prestation, facturePatientCeMois);
                lignePrestationService.ajouterLignePrestation(lignePrestation);
                return "redirect:/facture-prestations?patientId="+patient.getIdPatient()+"&success";
            }



        }
    }
}
