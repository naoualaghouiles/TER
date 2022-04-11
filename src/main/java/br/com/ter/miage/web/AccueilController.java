package br.com.ter.miage.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @GetMapping("/index")
    public String home() {
        return "index";
    }
}
