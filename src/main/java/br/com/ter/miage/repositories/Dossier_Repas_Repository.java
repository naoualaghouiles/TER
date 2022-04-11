package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Repas;
import br.com.ter.miage.entities.Repas;
import br.com.ter.miage.utilClass.RelationshipDossierRepas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface Dossier_Repas_Repository extends JpaRepository<Dossier_Repas, RelationshipDossierRepas> {

    @Transactional
    @Modifying
    @Query("delete from Dossier_Repas dr where dr.repas=:repas and dr.dossier=:dossier")
    void deleteRelation(@Param("repas") Repas repas, @Param("dossier") Dossier dossier);

//    @Transactional
//    @Modifying
//    void deleteDossier_RepasByRepasAndAndDossier(Repas repas, Dossier dossier);


    Boolean existsByDossierAndRepas(Dossier dossier, Repas repas);

    List<Dossier_Repas> findAllByDossier(Dossier dossier);

}