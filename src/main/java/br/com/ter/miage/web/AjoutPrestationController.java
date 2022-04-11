package br.com.ter.miage.web;


import br.com.ter.miage.dto.PrestationsDto;
import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.services.interfaces.PrestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutPrestationController {

    @Autowired
    PrestationService prestationService;

    @GetMapping("/ajoutPrestation")
    public String showAjoutAdminForm(Model model) {

        return "ajoutPrestation";
    }


    @ModelAttribute("prestation")
    public PrestationsDto prestationAddDto () {
        return new PrestationsDto();

    }


    @PostMapping("/ajoutPrestation")
    public String addPrestationsPost(@ModelAttribute("prestations") PrestationsDto prestationsDto) {
        Prestation prestation = prestationService.addPrestations(prestationsDto);
        if (prestation !=null){
            return "redirect:/listePrestation?success";
        }else{
            return "redirect:/ajoutPrestation?invalid";
        }

    }
}
