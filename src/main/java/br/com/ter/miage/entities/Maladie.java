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
public class Maladie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaladie;

    private String description;

//    @ManyToMany(mappedBy = "maladieSet", fetch = FetchType.EAGER)
//    private Set<Dossier> dossiers = new HashSet<>();

    public Maladie(String description) {
        this.description = description;
    }
}
