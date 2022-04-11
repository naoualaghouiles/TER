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

@Controller
public class AjoutParentController {

    @Autowired
    ParentPService parentPService;

    @GetMapping("/ajoutParent")
    public String showAjoutAdminForm(Model model) {

        return "ajoutParent";
    }

    @ModelAttribute("parent")
    public ParentDto parentAddDto () {
        return new ParentDto();

    }


    @PostMapping("/ajoutParent")
    public String addParentPost(@ModelAttribute("parent") ParentDto parentDto) {
        ParentP parentP =parentPService.addParentP(parentDto);
        if (parentP!=null){
            return "redirect:/listeParent?success";
        }else{
            return "redirect:/ajoutParent?invalid";
        }

    }
}
