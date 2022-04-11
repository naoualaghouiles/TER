package br.com.ter.miage.services;

import br.com.ter.miage.dto.AdminDto;
import br.com.ter.miage.entities.Admin;
import br.com.ter.miage.repositories.AdminRepository;
import br.com.ter.miage.services.interfaces.AdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

   // implements AdminService
    final
    AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

//    public Admin addAdmin(AdminDto adminDto) {
//        Admin admin = new Admin(
//                adminDto.getNom(),
//                adminDto.getPrenom(),
//                adminDto.getEmail(),
//                adminDto.getAdresse());
//
//        return adminRepository.save(admin);
//    }

    @Override
    public Admin addAdmin(AdminDto adminDto) {
        return null;
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public void ajouterAdmin(Admin admin){
        adminRepository.save(admin);
    }

    @Override
    public Admin getAdminByIdAdmin(Long idAdmin) {
        return adminRepository.findAdminByIdAdmin(idAdmin);
    }

    @Override
    public Admin getAdminByEmail(String email) {
        return adminRepository.findAdminByEmail(email);
    }

    @Override
    public List<Admin> getAdminByAdresse(String adresse) {
        return adminRepository.findAdminByAdresse(adresse);
    }

    @Override
    public List<Admin> getAdminByNom(String nom) {
        return adminRepository.findAdminByNom(nom);
    }

    @Override
    public List<Admin> getAdminByPrenom(String prenom) {
        return adminRepository.findAdminByPrenom(prenom);
    }

    @Override
    public Admin modifierAdmin(AdminDto AdminDto) throws ParseException {
        Admin admin = adminRepository.getById(AdminDto.getIdAdmin());

        admin.setAdresse(AdminDto.getAdresse());
        admin.setEmail(AdminDto.getEmail());
        admin.setNom(AdminDto.getNom());
        admin.setPrenom(AdminDto.getPrenom());

        return adminRepository.save(admin);

    }

    @Transactional
    @Override
    public void deleteAdmin(Long idAdmin) {
        adminRepository.deleteAdmin(idAdmin);
    }


    @Override
    public Admin addAdmins(AdminDto adminDto) {

        Admin admin = null;

        admin = new Admin(
                adminDto.getNom(),
                adminDto.getPrenom(),
                adminDto.getAdresse(),

                adminDto.getEmail()
        );
        return adminRepository.save(admin);

    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return adminRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException(
                        "User not found"));
    }
}
