package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Prestation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestation;

    private String designationP;
    private double prix;

    @OneToMany(mappedBy = "prestation",fetch = FetchType.EAGER)
    private Set<LignePrestation> lignePrestationSet;

    public Prestation(String designationP, double prix) {
        this.designationP = designationP;
        this.prix = prix;
    }


//    @ManyToMany(mappedBy = "prestationsSet", fetch = FetchType.EAGER)
//    private Set<Dossier> dossiers = new HashSet<>();
}
