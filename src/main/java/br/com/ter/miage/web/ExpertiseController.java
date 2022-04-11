package br.com.ter.miage.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpertiseController {

    @GetMapping("/expertise")
    public String home() {
        return "expertise";
    }
}
