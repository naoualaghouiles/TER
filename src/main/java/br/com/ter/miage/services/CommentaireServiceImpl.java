package br.com.ter.miage.services;

import br.com.ter.miage.dto.CommentaireDto;
import br.com.ter.miage.entities.Commentaire;
import br.com.ter.miage.repositories.CommentaireRepository;
import br.com.ter.miage.services.interfaces.CommentaireService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;


@Service
public class CommentaireServiceImpl implements CommentaireService {

    final
    CommentaireRepository commentaireRepository;

    public CommentaireServiceImpl(CommentaireRepository commentaireRepository) {
        this.commentaireRepository = commentaireRepository;
    }


    @Override
    public  void ajouterCommentaire(Commentaire commentaire){
        commentaireRepository.save(commentaire);
    }

    @Override
    public List<Commentaire> getAllCommentaire(){
        return commentaireRepository.findAll();
    }


    @Override
    public Commentaire getCommentaireById(Long idCommentaire){
        return commentaireRepository.findCommentaireByIdCommentaire(idCommentaire);
    }


    @Override
    public Commentaire modifierCommentaire(CommentaireDto commentaireDto) throws ParseException {
        Commentaire commentaire = commentaireRepository.getById(commentaireDto.getIdCommentaire());

        commentaire.setContenu(commentaireDto.getContenu());

        return commentaireRepository.save(commentaire);

    }


    @Transactional
    @Override
    public void deleteCommentaire(Long idCommentaire) {
        commentaireRepository.deleteCommentaire(idCommentaire);
    }


}
