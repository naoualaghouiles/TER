package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Maladie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MaladieRepository extends JpaRepository<Maladie, Long> {

    Maladie findMaladieByDescription(String description);


    Maladie findMaladieByIdMaladie(Long idMaladie);


    @Transactional
    @Modifying
    @Query("delete from Maladie m where m.idMaladie=:idMaladie")
    void deleteMaladie(@Param("idMaladie") Long idMaladie);

}
