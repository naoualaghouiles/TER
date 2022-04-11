package br.com.ter.miage.web;

import br.com.ter.miage.dto.InfermiereDto;
import br.com.ter.miage.entities.Infermiere;
import br.com.ter.miage.services.interfaces.InfermiereService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutInfermiereController {

    @Autowired
    InfermiereService infermiereService;

    @GetMapping("/ajoutInfermiere")
    public String showAjoutAdminForm(Model model) {

        return "ajoutInfermiere";
    }

    @ModelAttribute("infermiere")
    public InfermiereDto infermiereAddDto () {
        return new InfermiereDto();

    }

    @PostMapping("/ajoutInfermiere")
    public String addAdminPost(@ModelAttribute("infermiere") InfermiereDto infermiereDto) {
        Infermiere  infermiere=infermiereService.addInfermiere(infermiereDto);
        if (infermiere!=null){
            return "redirect:/listeInfermiere?success";
        }else{
            return "redirect:/ajoutInfermiere?invalid";
        }

    }

}
