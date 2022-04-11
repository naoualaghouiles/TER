package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Soins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSoin;

    private String designationS;

    @Temporal(TemporalType.DATE)
    private Date date;

    private String Commentaire;

    public Soins(String designationS, Date date, String commentaire) {
        this.designationS = designationS;
        this.date = date;
        Commentaire = commentaire;
    }

//    @ManyToOne(fetch = FetchType.EAGER,optional = false)
//    @JoinColumn(name = "idDossier",nullable = false)
//    private Dossier dossier;

}
