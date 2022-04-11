package br.com.ter.miage.web;


import br.com.ter.miage.dto.DirecteurDto;
import br.com.ter.miage.entities.Directeur;
import br.com.ter.miage.services.interfaces.DirecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class DirecteurController {


    @Autowired
    DirecteurService directeurService;


    @GetMapping("/ajoutDirecteur")
    public String showAjoutAdminForm(Model model) {

        return "ajoutDirecteur";
    }


    @ModelAttribute("directeur")
    public DirecteurDto directeurAddDto () {
        return new DirecteurDto();

    }


    @PostMapping("/ajoutDirecteur")
    public String addDirecteruPost(@ModelAttribute("directeur") DirecteurDto directeurDto) {
        Directeur directeur =directeurService.addDirecteur(directeurDto);
        if (directeur!=null){
            return "redirect:/directeurL?success";
        }else{
            return "redirect:/ajoutDirecteur?invalid";
        }

    }


    @GetMapping("/directeurL")
    public String showListerPage( Model model) {

        List<Directeur> directeurList= directeurService.getAllDirecteurs();

        model.addAttribute("directeurList",directeurList);

        return "directeurL";
    }

    @GetMapping("deleteDirecteur")
    public String deleteDirecteur(Model model,@RequestParam("idDirecteur") Long idDirecteur){
        directeurService.deleteDirecteur(idDirecteur);
        return "redirect:/directeurL?deleteSuccess";
    }



    @GetMapping("/modifierDirecteur")
    public String showOperatriceForm(Model model, @RequestParam("idDirecteur") Long idDirecteur) {
        Directeur directeur = directeurService.getDirecteurById(idDirecteur);
        DirecteurDto directeurDto =new DirecteurDto(
                idDirecteur,
                directeur.getNom(),
                directeur.getPrenom(),
                directeur.getEmail()
        );
        model.addAttribute("directeur",directeurDto);
        return "modifierDirecteur";
    }


    @PostMapping("/modifierDirecteur")
    public String addAdminPost(@ModelAttribute("directeur")  DirecteurDto directeurDto){
        try {
            directeurService.modifierDirecteur(directeurDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierDirecteur?invalid";
        }
        return "redirect:/directeurL?deleteSuccess?modifieSuccess";
    }

}
