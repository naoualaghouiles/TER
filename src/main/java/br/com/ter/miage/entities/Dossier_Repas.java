package br.com.ter.miage.entities;

import br.com.ter.miage.utilClass.RelationshipDossierRepas;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Dossier_Repas implements Serializable {

    @EmbeddedId
    private RelationshipDossierRepas id = new RelationshipDossierRepas();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dossierId")
    private Dossier dossier;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("repasId")
    private Repas repas;


    public Dossier_Repas(Dossier dossier, Repas repas) {
        this.dossier = dossier;
        this.repas = repas;
    }
}