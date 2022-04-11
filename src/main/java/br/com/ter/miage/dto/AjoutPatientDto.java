package br.com.ter.miage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AjoutPatientDto {
    private Long idPatient;
    private String nom;
    private String prenom;
    private String email;
    private String adresse;
    private String numTel;
    private String sexe;
    private String dateNaissance;
    private String dateEntree;
    private Long idGir;


    public AjoutPatientDto(String nom, String prenom, String email, String adresse,
                           String numTel, String sexe, String dateNaissance, String dateEntree, Long idGir) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.adresse = adresse;
        this.numTel = numTel;
        this.sexe = sexe;
        this.dateNaissance = dateNaissance;
        this.dateEntree = dateEntree;
        this.idGir = idGir;
    }
}
