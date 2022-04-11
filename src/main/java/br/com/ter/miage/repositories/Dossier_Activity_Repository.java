package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.utilClass.RelationshipDossierActivity;
import br.com.ter.miage.utilClass.RelationshipDossierRepas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dossier_Activity_Repository extends JpaRepository<Dossier_Activity, RelationshipDossierActivity> {

    @Transactional
    @Modifying
    @Query("delete from Dossier_Activity dr where dr.activity=:activity and dr.dossier=:dossier")
    void deleteRelation(@Param("activity") Activity activity, @Param("dossier") Dossier dossier);

//    @Transactional
//    @Modifying
//    void deleteDossier_RepasByRepasAndAndDossier(Repas repas, Dossier dossier);


    Boolean existsByDossierAndActivity(Dossier dossier, Activity activity);

    List<Dossier_Activity> findAllByDossier(Dossier dossier);

}