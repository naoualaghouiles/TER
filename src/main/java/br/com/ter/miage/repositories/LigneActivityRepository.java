package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LigneActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface LigneActivityRepository extends JpaRepository<LigneActivity,Long> {
    LigneActivity findLigneActivityByIdLigneActivity(Long idLigne);

    Boolean existsByActivityAndFacture(Activity activity, Facture facture);

    LigneActivity findByActivityAndFacture(Activity activity, Facture facture);

    @Transactional
    @Modifying
    @Query("delete from LigneActivity l where l.idLigneActivity=:idLigneActivity")
    void deleteLigneActivity(@Param("idLigneActivity") Long idLigneActivity);

}
