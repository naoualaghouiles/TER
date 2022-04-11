package br.com.ter.miage.web.directeur;

import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.services.interfaces.FactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DirecteurFacturePatientController {

    @Autowired
    FactureService factureService;

    @GetMapping("/payer/{factureId}")
    public String validateFacture(Model model, @PathVariable("factureId") Long factureId) {
        Facture facture = factureService.getById(factureId);
        facture.setEtat("Payée");
        factureService.ajouterFacture(facture);

        return "redirect:/directeur-facture?patientId=" + facture.getPatient().getIdPatient();
    }
}
