package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.CommentaireDto;
import br.com.ter.miage.entities.Commentaire;

import java.text.ParseException;
import java.util.List;

public interface CommentaireService {

    Commentaire getCommentaireById(Long idCommentaire);
    void ajouterCommentaire(Commentaire commentaire);
    List<Commentaire> getAllCommentaire();
    void deleteCommentaire(Long idCommentaire);
    Commentaire modifierCommentaire(CommentaireDto commentaireDto) throws ParseException;

}
