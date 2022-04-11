package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Medicaments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicaments;

    private String designationMed;


    public Medicaments(String designationMed) {
        this.designationMed = designationMed;
    }


//    @ManyToMany(mappedBy = "medicamentsSet", fetch = FetchType.EAGER)
//    private Set<Dossier> dossiers = new HashSet<>();
}
