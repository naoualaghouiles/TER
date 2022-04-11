package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Soins;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Repository
public interface SoinsRepository extends JpaRepository<Soins, Long> {

    List<Soins> findSoinsByDesignationS(String designationS);

    List<Soins> findSoinsByDate(Date date);

    Soins findSoinsByIdSoin(Long idSoin);

    @Transactional
    @Modifying
    @Query("delete from Soins s where s.idSoin=:idSoin")
    void deleteSoins(@Param("idSoin") Long idSoin);


}
