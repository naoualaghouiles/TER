package br.com.ter.miage.web;


import br.com.ter.miage.dto.AdminDto;
import br.com.ter.miage.entities.Admin;
import br.com.ter.miage.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;


@Controller
public class ModifierAdminController {


    @Autowired
    AdminService adminService;


    @GetMapping("/modifierAdmins")
    public String showAdminForm(Model model, @RequestParam("idAdmin") Long idAdmin) {
        Admin admin = adminService.getAdminByIdAdmin(idAdmin);
        AdminDto adminDto=new AdminDto(
                idAdmin,
                admin.getNom(),
                admin.getPrenom(),
                admin.getEmail(),
                admin.getAdresse()
        );
        model.addAttribute("admin",adminDto);
        return "modifierAdmins";
    }

    @ModelAttribute("admin")
    public AdminDto adminAddDto(){
        return new AdminDto();
    }

    @PostMapping("/modifierAdmins")
    public String addAdminPost(@ModelAttribute("admin") AdminDto adminDto){
        try {
            adminService.modifierAdmin(adminDto);
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/modifierAdmins?invalid";
        }
        return "redirect:/listeAdmins?modifieSuccess";
    }


}
