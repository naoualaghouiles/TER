package br.com.ter.miage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PatientDto {
    private String prenom;
    private String nom;
    private String email;
    private String password;
    private String sexe;
    private String adresse;
    private Integer dureeSejour;


}
