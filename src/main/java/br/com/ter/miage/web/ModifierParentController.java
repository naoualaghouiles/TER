package br.com.ter.miage.web;


import br.com.ter.miage.dto.ParentDto;
import br.com.ter.miage.entities.ParentP;
import br.com.ter.miage.services.interfaces.ParentPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;


@Controller
public class ModifierParentController {
    @Autowired
    ParentPService parentPService;



    @GetMapping("/modifierParent")
    public String showAdminForm(Model model, @RequestParam("idParentP") Long idParentP) {
       ParentP parentP = parentPService.getParentPByIdParentP(idParentP);
        ParentDto parentDto =new ParentDto(
                idParentP,
                parentP.getNomP(),
                parentP.getPrenomP(),
                parentP.getAdresseP(),
                parentP.getEmailP()
        );
        model.addAttribute("parent",parentDto);
        return "modifierParent";
    }

    @ModelAttribute("parent")
    public ParentDto parentAddDto(){
        return new ParentDto();
    }




    @PostMapping("/modifierParent")
    public String addParentPost(@ModelAttribute("parent") ParentDto parentDto){
        try {
            parentPService.modifierParent(parentDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierParent?invalid";
        }
        return "redirect:/listeParent?modifieSuccess";
    }


}
