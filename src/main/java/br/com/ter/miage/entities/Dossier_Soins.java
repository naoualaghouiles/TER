package br.com.ter.miage.entities;

import br.com.ter.miage.utilClass.RelationshipDossierSoins;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Dossier_Soins implements Serializable {

    @EmbeddedId
    private RelationshipDossierSoins id = new RelationshipDossierSoins();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dossierId")
    private Dossier dossier;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("soinsId")
    private Soins soins;


    public Dossier_Soins(Dossier dossier, Soins soins) {
        this.dossier = dossier;
        this.soins = soins;
    }
}