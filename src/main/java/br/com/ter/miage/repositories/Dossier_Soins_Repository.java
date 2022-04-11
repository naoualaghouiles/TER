package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Soins;
import br.com.ter.miage.utilClass.RelationshipDossierSoins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dossier_Soins_Repository extends JpaRepository<Dossier_Soins, RelationshipDossierSoins> {

    @Transactional
    @Modifying
    @Query("delete from Dossier_Soins dr where dr.soins=:soins and dr.dossier=:dossier")
    void deleteRelation(@Param("soins") Soins soins, @Param("dossier") Dossier dossier);

//    @Transactional
//    @Modifying
//    void deleteDossier_RepasByRepasAndAndDossier(Repas repas, Dossier dossier);


    Boolean existsByDossierAndSoins(Dossier dossier, Soins soins);

    List<Dossier_Soins> findAllByDossier(Dossier dossier);

}