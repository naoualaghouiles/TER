package br.com.ter.miage.web.operatrice;

import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.services.interfaces.DossierActivityService;
import br.com.ter.miage.services.interfaces.DossierPrestationService;
import br.com.ter.miage.services.interfaces.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OperatriceFactureController {

    @Autowired
    FactureService factureService;

    @Autowired
    DossierActivityService dossierActivityService;

    @Autowired
    DossierPrestationService dossierPrestationService;

    @GetMapping("/facture")
    public String showFacture(Model model, @RequestParam("factureId") Long factureId) {
        Facture facture = factureService.getById(factureId);

        if (facture == null) {
            return "redirect:/error";
        }

        List<Activity> activityList = dossierActivityService.getPatientActivity(facture.getPatient());
        model.addAttribute("activityList", activityList);

        List<Prestation> prestationList = dossierPrestationService.getPatientPrestation(facture.getPatient());
        model.addAttribute("prestationList", prestationList);

        model.addAttribute("facture", facture);

        int nombreJours = factureService.getJourSejour(activityList, prestationList, facture);

        model.addAttribute("nombreJours", nombreJours);

        double prixSejour = nombreJours * facture.getPatient().getGir().getPrix();

        model.addAttribute("prixSejour", prixSejour);

        return "facture-voir";
    }

    @GetMapping("/valider/{factureId}")
    public String validateFacture(Model model, @PathVariable("factureId") Long factureId) {
        Facture facture = factureService.getById(factureId);
        facture.setEtat("Confirmée");
        factureService.ajouterFacture(facture);

        return "redirect:/facture-patient?patientId=" + facture.getPatient().getIdPatient();
    }

}
