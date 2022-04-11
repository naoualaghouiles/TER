package br.com.ter.miage.web;


import br.com.ter.miage.dto.ActiviteDto;
import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.services.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AjoutActivitiesController {

    @Autowired
    ActivityService activityService;

    @GetMapping("/ajoutActivities")
    public String showAjoutAdminForm(Model model) {

        return "ajoutActivities";
    }


    @ModelAttribute("activity")
    public ActiviteDto activiteAddDto () {
        return new ActiviteDto();

    }


    @PostMapping("/ajoutActivities")
    public String addPrestationsPost(@ModelAttribute("activities") ActiviteDto activiteDto) {
        Activity activity = activityService.addActivity(activiteDto);
        if (activity !=null){
            return "redirect:/listeActivities?success";
        }else{
            return "redirect:/ajoutActivities?invalid";
        }

    }
}
