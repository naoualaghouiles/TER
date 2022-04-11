package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.utilClass.RelationshipDossierActivity;
import br.com.ter.miage.utilClass.RelationshipDossierMedicaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dossier_Medicaments_Repository extends JpaRepository<Dossier_Medicaments,
        RelationshipDossierMedicaments> {

    @Transactional
    @Modifying
    @Query("delete from Dossier_Medicaments dm where dm.medicaments=:medicaments and dm.dossier=:dossier")
    void deleteRelation(@Param("medicaments") Medicaments medicaments, @Param("dossier") Dossier dossier);

//    @Transactional
//    @Modifying
//    void deleteDossier_RepasByRepasAndAndDossier(Repas repas, Dossier dossier);


    Boolean existsByDossierAndMedicaments(Dossier dossier, Medicaments medicaments);

    List<Dossier_Medicaments> findAllByDossier(Dossier dossier);

}