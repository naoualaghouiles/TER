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
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idActivity;

    private Double prixA;
    private String description;

    public Activity(Double prixA, String description) {
        this.prixA = prixA;
        this.description = description;
    }

    @OneToMany(mappedBy = "activity",fetch = FetchType.EAGER)
    private Set<LigneActivity> ligneActivitySet;


//    @ManyToMany(mappedBy = "activitiesSet", fetch = FetchType.EAGER)
//    private Set<Dossier> dossiers = new HashSet<>();
}
