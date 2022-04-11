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
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.util.List;

@Controller
public class ListeInfermiereController {


    @Autowired
    InfermiereService infermiereService;


    @GetMapping("/listeInfermiere")
    public String showListerPage(Model model) {
        List<Infermiere> infermiereList = infermiereService.getAllInfermieres();

        model.addAttribute("infermiereList", infermiereList);

        return "listeInfermiere";
    }


    @GetMapping("deleteInfermiere")
    public String deleteAdmin(Model model, @RequestParam("idInfermiere") Long idInfermiere){
        infermiereService.deleteInfermiere(idInfermiere);
        return  "redirect:/listeInfermiere?deleteSuccess";
    }



    @GetMapping("/modifierInfermiere")
    public String showAdminForm(Model model, @RequestParam("idInfermiere") Long idInfermiere) {
        Infermiere infermiere = infermiereService.getInfermiereByIdInfermiere(idInfermiere);
        InfermiereDto infermiereDto =new InfermiereDto(
                idInfermiere,
                infermiere.getNom(),
                infermiere.getPrenom(),
                infermiere.getEmail()
        );
        model.addAttribute("infermiere",infermiereDto);
        return "modifierInfermiere";
    }

    @ModelAttribute("infermiere")
    public InfermiereDto adminAddDto(){
        return new InfermiereDto();
    }

    @PostMapping("/modifierInfermiere")
    public String addInfermierePost(@ModelAttribute("infermiere") InfermiereDto infermiereDto){
        try {
            infermiereService.modifierInfermiere(infermiereDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierInfermiere?invalid";
        }
        return "redirect:/listeInfermiere?modifieSuccess";
    }

}
