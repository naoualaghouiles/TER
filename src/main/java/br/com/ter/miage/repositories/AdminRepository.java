package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Admin;
import br.com.ter.miage.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByEmail(String email);

    Admin findAdminByIdAdmin(Long idAdmin);
    List<Admin> findAdminByNom(String nom);
    List<Admin> findAdminByPrenom(String prenom);
    Admin findAdminByEmail(String email);
    List<Admin> findAdminByAdresse(String adresse);

    @Transactional
    @Modifying
    @Query("delete from Admin a where a.idAdmin=:idAdmin")
    void deleteAdmin(@Param("idAdmin") Long idAdmin);
}
