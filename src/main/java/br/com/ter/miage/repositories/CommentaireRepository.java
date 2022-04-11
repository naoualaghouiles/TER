package br.com.ter.miage.repositories;



import br.com.ter.miage.entities.Commentaire;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire,Long> {


    Commentaire findCommentaireByIdCommentaire(Long idCommentaire);

    @Transactional
    @Modifying
    @Query("delete from Commentaire c where c.idCommentaire=:idCommentaire")
    void deleteCommentaire(@Param("idCommentaire") Long idCommentaire);

}
