package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Operatrice;
import br.com.ter.miage.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperatriceRepository extends JpaRepository<Operatrice,Long> {

    Optional<Operatrice> findByEmail(String email);

    List<Operatrice> findOperatriceByNom(String nom);
    List<Operatrice> findOperatriceByPrenom(String prenom);
    Operatrice findOperatriceByEmail(String email);
    Operatrice findOperatriceByIdOperatrice(Long idOperatrice);


    @Transactional
    @Modifying
    @Query("delete from Operatrice o where o.idOperatrice=:idOperatrice")
    void deleteOperatrice(@Param("idOperatrice") Long idOperatrice);
}
