package br.com.ter.miage.web;


import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.services.interfaces.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListeActivitiesController {


    @Autowired
    ActivityService activityService;

    @GetMapping("/listeActivities")
    public String showListerPage( Model model) {

        List<Activity> activityList = activityService.getAllActivities();

        model.addAttribute("activityList", activityList);

        return "listeActivities";
    }

    @GetMapping("deleteActivities")
    public String deleteActivities(Model model,@RequestParam("idActivities") Long idActivities){
        activityService.deleteActivity(idActivities);
        return "redirect:/listeActivities?deleteSuccess";
    }


}
