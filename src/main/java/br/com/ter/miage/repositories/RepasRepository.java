package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Repas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface RepasRepository extends JpaRepository<Repas, Long> {
    Repas findRepasByDesignation(String designation);

    Repas findRepasByIdRepas(Long idRepas);


    @Transactional
    @Modifying
    @Query("delete from Repas r where r.idRepas=:idRepas")
    void deleteRepas(@Param("idRepas") Long idRepas);



}
