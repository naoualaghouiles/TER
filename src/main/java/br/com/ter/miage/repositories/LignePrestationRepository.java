package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LignePrestationRepository extends JpaRepository<LignePrestation,Long> {
    LignePrestation findLignePrestationByIdLignePrestation(Long idLigne);

    Boolean existsByPrestationAndFacture(Prestation prestation, Facture facture);

    LignePrestation findByPrestationAndFacture(Prestation prestation, Facture facture);


    @Transactional
    @Modifying
    @Query("delete from LignePrestation l where l.idLignePrestation=:idLignePrestation")
    void deleteLignePrestation(@Param("idLignePrestation") Long idLignePrestation);

}
