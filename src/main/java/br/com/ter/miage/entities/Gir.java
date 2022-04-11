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
public class Gir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idGir;

    private String type;
    private Double prix;

    public Gir(String type, Double prix) {
        this.type = type;
        this.prix = prix;
    }

    @OneToMany(mappedBy = "gir",fetch = FetchType.EAGER)
    private Set<Patient> patients;

}
