package br.com.ter.miage.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NosServiceController {


    @GetMapping("/nosservice")
    public String home() {
        return "nosservice";
    }

}
