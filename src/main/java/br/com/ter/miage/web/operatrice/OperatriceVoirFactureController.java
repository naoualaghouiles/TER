package br.com.ter.miage.web.operatrice;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.services.interfaces.FactureService;
import br.com.ter.miage.services.interfaces.LigneActivityService;
import br.com.ter.miage.services.interfaces.LignePrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class OperatriceVoirFactureController {

    @Autowired
    FactureService factureService;

    @Autowired
    LigneActivityService ligneActivityService;

    @Autowired
    LignePrestationService lignePrestationService;

    @GetMapping("facture-details")
    public String factureDetails(Model model, @RequestParam("factureId") Long factureId) {
        Facture facture = factureService.getById(factureId);

        if (facture == null) {
            return "redirect:/error";
        } else {
            Set<LigneActivity> ligneActivitySet = facture.getLigneActivitySet();
            Set<LignePrestation> lignePrestationSet = facture.getLignePrestationSet();

            List<Activity> activityList = new ArrayList<>();

            for (LigneActivity ligneActivity :
                    ligneActivitySet) {
                activityList.add(ligneActivity.getActivity());
            }

            List<Prestation> prestationList = new ArrayList<>();

            for (LignePrestation lignePrestation :
                    lignePrestationSet) {
                prestationList.add(lignePrestation.getPrestation());
            }

            int jourSejour = factureService.getJourSejour(activityList, prestationList, facture);

            model.addAttribute("activityList", activityList);
            model.addAttribute("prestationList", prestationList);
            model.addAttribute("facture", facture);
            model.addAttribute("jourSejour", jourSejour);
        }

        return "facture-details";
    }

    @GetMapping("/deleteActivityFacture/{idActivity}")
    public String deleteActivityFacture(Model model, @PathVariable Long idActivity,
                                        @RequestParam("factureId") Long factureId) {

        ligneActivityService.deleteLigneBy(idActivity, factureId);

        return "redirect:/facture-details?success&factureId=" + factureId;
    }

    @GetMapping("/deletePrestationFacture/{idPrestation}")
    public String deletePrestationFacture(Model model, @PathVariable Long idPrestation,
                                        @RequestParam("factureId") Long factureId) {

        lignePrestationService.deleteLigneBy(idPrestation, factureId);

        return "redirect:/facture-details?success&factureId=" + factureId;
    }
}
