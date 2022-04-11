package br.com.ter.miage.repositories;



import br.com.ter.miage.entities.Gir;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface GirRepository extends JpaRepository<Gir, Long> {


    List<Gir> findGirByType(String type);

    List<Gir> findAllByPrix(Double prix);

    Gir findGirByIdGir(Long idGir);


    @Transactional
    @Modifying
    @Query("delete from Gir g where g.idGir=:idGir")
    void deleteGir(@Param("idGir") Long idGir);

}
