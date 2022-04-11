package br.com.ter.miage.web;


import br.com.ter.miage.entities.Operatrice;
import br.com.ter.miage.services.interfaces.OperatriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListeOperatriceController {


    @Autowired
    OperatriceService operatriceService;


    @GetMapping("/listeOperatrice")
    public String showListerPage(Model model) {
        List<Operatrice> operatriceList = operatriceService.getAllOperatrice();

        model.addAttribute("operatriceList", operatriceList);

        return "listeOperatrice";
    }


    @GetMapping("deleteOperatrice")
    public String deleteOperatrice(Model model, @RequestParam("idOperatrice") Long idOperatrice){
        operatriceService.deleteOperatrice(idOperatrice);
        return  "redirect:/listeOperatrice?deleteSuccess";
    }
}
