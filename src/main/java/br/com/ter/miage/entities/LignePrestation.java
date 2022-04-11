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
public class LignePrestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLignePrestation;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idPrestation",nullable = false)
    private Prestation prestation;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idFacture",nullable = false)
    private Facture facture;

    public LignePrestation(Prestation prestation, Facture facture) {
        this.prestation = prestation;
        this.facture = facture;
    }
}
