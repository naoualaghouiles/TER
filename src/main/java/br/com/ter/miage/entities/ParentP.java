package br.com.ter.miage.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class ParentP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idParentP;

    private String nomP;

    private String prenomP;
    private  String adresseP;

    private String emailP;

    private String passwordP;


    public ParentP(String nomP, String prenomP, String adresseP, String emailP, String passwordP) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.adresseP = adresseP;
        this.emailP = emailP;
        this.passwordP = passwordP;
    }


    public ParentP(String nomP, String prenomP, String adresseP, String emailP) {
        this.nomP = nomP;
        this.prenomP = prenomP;
        this.adresseP = adresseP;
        this.emailP = emailP;
    }
}
