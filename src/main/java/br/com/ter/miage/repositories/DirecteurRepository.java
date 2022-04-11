package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Directeur;
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
public interface DirecteurRepository  extends JpaRepository<Directeur,Long> {

    Optional<Directeur> findByEmail(String email);

    List<Directeur> findDirecteurByNom(String nom);
    List<Directeur> findDirecteurByPrenom(String prenom);
    Directeur findDirecteurByEmail(String email);
    Directeur findDirecteurByIdDirecteur(Long idDirecteur);


    @Transactional
    @Modifying
    @Query("delete from Directeur d where d.idDirecteur=:idDirecteur")
    void deleteDirecteur(@Param("idDirecteur") Long idDirecteur);

}
