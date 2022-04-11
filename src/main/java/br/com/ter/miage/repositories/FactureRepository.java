package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface FactureRepository  extends JpaRepository<Facture, Long> {


    List<Facture> findFactureByEtat(String etat);

    List<Facture> findAllByDateF(Date date);



    @Transactional
    @Modifying
    @Query("delete from Facture f where f.idFacture=:idFacture")
    void deleteFacture(@Param("idFacture") Long idFacture);

}
