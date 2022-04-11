package br.com.ter.miage.web;

import br.com.ter.miage.dto.OperatriceDto;
import br.com.ter.miage.entities.Operatrice;
import br.com.ter.miage.services.interfaces.OperatriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutOperatriceController {

    @Autowired
    OperatriceService operatriceService;

    @GetMapping("/ajoutOperatrice")
    public String showAjoutAdminForm(Model model) {

        return "ajoutOperatrice";
    }

    @ModelAttribute("operatrice")
    public OperatriceDto operatriceAddDto () {
        return new OperatriceDto();

    }

    @PostMapping("/ajoutOperatrice")
    public String addOperatricePost(@ModelAttribute("operatrice") OperatriceDto operatriceDto) {
        Operatrice operatrice=operatriceService.addOperatrice(operatriceDto);
        if (operatrice!=null){
            return "redirect:/listeOperatrice?success";
        }else{
            return "redirect:/ajoutOperatrice?invalid";
        }

    }

}
