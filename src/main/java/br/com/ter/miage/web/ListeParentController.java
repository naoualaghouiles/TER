package br.com.ter.miage.web;


import br.com.ter.miage.entities.ParentP;
import br.com.ter.miage.services.interfaces.ParentPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListeParentController {


    @Autowired
    ParentPService parentPService;


    @GetMapping("/listeParent")
    public String showListerPage(Model model) {
        List<ParentP> parentPList = parentPService.getAllParentP();

        model.addAttribute("parentPList", parentPList);

        return "listeParent";
    }


    @GetMapping("deleteParentP")
    public String deleteParentP(Model model, @RequestParam("idParentP") Long idParentP){
        parentPService.deleteParentP(idParentP);
        return  "redirect:/listeParent?deleteSuccess";
    }
}
