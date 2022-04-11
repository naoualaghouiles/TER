package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.AdminDto;
import br.com.ter.miage.entities.Admin;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;

public interface AdminService extends UserDetailsService {
    Admin addAdmin(AdminDto adminDto);
    List<Admin> getAllAdmins();
    void ajouterAdmin(Admin admin);
    Admin getAdminByIdAdmin(Long idAdmin);
    Admin getAdminByEmail(String email);
    List<Admin> getAdminByAdresse(String adresse);
    List<Admin> getAdminByPrenom(String prenom);
    List<Admin> getAdminByNom(String nom);
    void deleteAdmin(Long idAdmin);
    Admin modifierAdmin(AdminDto AdminDto) throws ParseException;

    Admin addAdmins(AdminDto adminDto);
}
