package br.com.ter.miage.web;


import br.com.ter.miage.entities.Admin;
import br.com.ter.miage.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ListeAdminController {


    @Autowired
    AdminService adminService;


    @GetMapping("/listeAdmins")
    public String showListerPage(Model model) {
        List<Admin> adminList = adminService.getAllAdmins();

        model.addAttribute("adminList", adminList);

        return "listeAdmins";
    }


    @GetMapping("deleteAdmin")
    public String deleteAdmin(Model model, @RequestParam("idAdmin") Long idAdmin){
        adminService.deleteAdmin(idAdmin);
        return  "redirect:/listeAdmins?deleteSuccess";
    }
}
