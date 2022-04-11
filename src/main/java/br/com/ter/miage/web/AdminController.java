package br.com.ter.miage.web;

import br.com.ter.miage.dto.AdminDto;
import br.com.ter.miage.services.AdminServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AdminController {

    final
    AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }


    @ModelAttribute("adminReg")
    public AdminDto adminRegistrationDto() {
        return new AdminDto();
    }


//    @PostMapping("/inscription")
//    public String registerAdmin(@ModelAttribute AdminDto adminDto) {
//        adminService.addAdmin(adminDto);
//        return "redirect:/admin?success";
//    }
//
//
//    @GetMapping("/patients")
//    public String showRegistrationForm(Model model) {
//
//        List<Admin> patientList = adminService.getAllAdmins();
//        model.addAttribute("listPatient", patientList);
//        return "patients";
//    }
}
