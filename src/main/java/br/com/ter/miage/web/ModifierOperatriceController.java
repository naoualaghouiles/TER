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
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;


@Controller
public class ModifierOperatriceController {

    @Autowired
    OperatriceService operatriceService;



    @GetMapping("/modifierOperatrice")
    public String showOperatriceForm(Model model, @RequestParam("idOperatrice") Long idOperatrice) {
        Operatrice operatrice = operatriceService.getOperatriceByIdOperatrice(idOperatrice);
        OperatriceDto operatriceDto =new OperatriceDto(
                idOperatrice,
                operatrice.getNom(),
                operatrice.getPrenom(),
                operatrice.getEmail()
        );
        model.addAttribute("operatrice",operatriceDto);
        return "modifierOperatrice";
    }

    @ModelAttribute("operatrice")
    public OperatriceDto operatriceAddDto(){
        return new OperatriceDto();
    }

    @PostMapping("/modifierOperatrice")
    public String addAdminPost(@ModelAttribute("operatrice")  OperatriceDto operatriceDto){
        try {
            operatriceService.modifierOperatrice(operatriceDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierOperatrice?invalid";
        }
        return "redirect:/listeOperatrice?modifieSuccess";
    }


}
