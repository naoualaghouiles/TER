package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
  List<Prestation> findPrestationsByDesignationP(String designationP);


  List<Prestation> findPrestationsByPrix(Double prix);

  Prestation findPrestationsByIdPrestation(Long idPrestation);


  @Transactional
  @Modifying
  @Query("delete from Prestation p where p.idPrestation=:idPrestation")
  void deletePrestations(@Param("idPrestation") Long idPrestation);




}
