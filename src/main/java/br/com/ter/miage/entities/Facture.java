package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFacture;

    private String etat;

    private double prixTotal;

    @Temporal(TemporalType.DATE)
    private Date dateF;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idPatient", nullable = false)
    private Patient patient;

    @OneToMany(mappedBy = "facture",fetch = FetchType.EAGER)
    private Set<LigneActivity> ligneActivitySet;

    @OneToMany(mappedBy = "facture",fetch = FetchType.EAGER)
    private Set<LignePrestation> lignePrestationSet;

    public Facture(String etat, Date dateF, Patient patient) {
        this.etat = etat;
        this.dateF = dateF;
        this.patient = patient;
    }
}
