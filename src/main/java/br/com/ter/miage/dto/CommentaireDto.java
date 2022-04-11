package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentaireDto {

    private Long idCommentaire;

    private String contenu;

    public CommentaireDto(String contenu) {
        this.contenu = contenu;
    }
}
