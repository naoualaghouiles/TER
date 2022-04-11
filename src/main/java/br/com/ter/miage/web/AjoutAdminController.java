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

@Controller
public class AjoutAdminController {

    @Autowired
    AdminService adminService;

    @GetMapping("/ajoutAdmins")
    public String showAjoutAdminForm(Model model) {

        return "ajoutAdmins";
    }

    @ModelAttribute("admin")
    public AdminDto adminAddDto () {
        return new AdminDto();

    }


    @PostMapping("/ajoutAdmins")
    public String addAdminPost(@ModelAttribute("admin") AdminDto adminDto) {
        Admin admin=adminService.addAdmins(adminDto);
        if (admin!=null){
            return "redirect:/listeAdmins?success";
        }else{
            return "redirect:/ajoutAdmins?invalid";
        }

    }
}
