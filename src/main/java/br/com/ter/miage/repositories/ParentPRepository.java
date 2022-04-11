package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.ParentP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface ParentPRepository extends JpaRepository<ParentP,Long> {

    List<ParentP> findParentPByNomP(String nomP);
    List<ParentP> findParentPByPrenomP(String prenomP);
    ParentP findParentPByEmailP(String emailP);
    ParentP findParentPByIdParentP(Long idParentP);


    @Transactional
    @Modifying
    @Query("delete from ParentP p where p.idParentP=:idParentP")
    void deleteParentP(@Param("idParentP") Long idParentP);
}
