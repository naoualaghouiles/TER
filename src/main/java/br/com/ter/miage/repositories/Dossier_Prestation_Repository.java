package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.utilClass.RelationshipDossierActivity;
import br.com.ter.miage.utilClass.RelationshipDossierPrestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dossier_Prestation_Repository extends JpaRepository<Dossier_Prestation, RelationshipDossierPrestation> {

    @Transactional
    @Modifying
    @Query("delete from Dossier_Prestation dr where dr.prestation=:prestation and dr.dossier=:dossier")
    void deleteRelation(@Param("prestation") Prestation prestation, @Param("dossier") Dossier dossier);

//    @Transactional
//    @Modifying
//    void deleteDossier_RepasByRepasAndAndDossier(Repas repas, Dossier dossier);


    Boolean existsByDossierAndPrestation(Dossier dossier, Prestation prestation);

    List<Dossier_Prestation> findAllByDossier(Dossier dossier);

}