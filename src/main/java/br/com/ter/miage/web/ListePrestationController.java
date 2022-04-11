package br.com.ter.miage.web;


import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.services.interfaces.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListePrestationController {


    @Autowired
    PrestationService prestationService;

    @GetMapping("/listePrestation")
    public String showListerPage( Model model) {

        List<Prestation> prestationList = prestationService.getAllPrestations();

        model.addAttribute("prestationList", prestationList);

        return "listePrestation";
    }

    @GetMapping("deletePrestation")
    public String deleteActivities(Model model,@RequestParam("idPrestation") Long idPrestation){
        prestationService.deletePrestations(idPrestation);
        return "redirect:/listePrestation?deleteSuccess";
    }

}
