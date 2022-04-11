package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SoinsDto {

    private Long idSoin;

    private String designationS;

    private String date;

    private String Commentaire;

    public SoinsDto(String designationS, String date, String commentaire) {
        this.designationS = designationS;
        this.date = date;
        Commentaire = commentaire;
    }
}
