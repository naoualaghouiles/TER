package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParentDto {
    private Long idParentP;

    private String nomP;

    private String prenomP;
    private  String adresseP;

    private String emailP;

    public ParentDto(String nomP, String prenomP, String adresseP, String emailP) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.adresseP = adresseP;
        this.emailP = emailP;
    }
}
