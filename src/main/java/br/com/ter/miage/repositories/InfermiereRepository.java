package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Admin;
import br.com.ter.miage.entities.Infermiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface InfermiereRepository extends JpaRepository<Infermiere, Long> {

    Optional<Infermiere> findByEmail(String email);

    Infermiere  findInfermiereByEmail(String email);
    List<Infermiere>  findInfermiereByNom(String nom);
    List<Infermiere>  findInfermiereByPrenom(String prenom);
    Infermiere findInfermiereByIdInfermiere(Long idInfermiere);


    @Transactional
    @Modifying
    @Query("delete from Infermiere i where i.idInfermiere=:idInfermiere")
    void deleteInfermiere(@Param("idInfermiere") Long idInfermiere);

}
