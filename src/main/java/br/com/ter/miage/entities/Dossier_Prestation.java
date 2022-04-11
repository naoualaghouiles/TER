package br.com.ter.miage.entities;

import br.com.ter.miage.utilClass.RelationshipDossierActivity;
import br.com.ter.miage.utilClass.RelationshipDossierPrestation;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Dossier_Prestation implements Serializable {

    @EmbeddedId
    private RelationshipDossierPrestation id = new RelationshipDossierPrestation();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dossierId")
    private Dossier dossier;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("prestationId")
    private Prestation prestation;


    public Dossier_Prestation(Dossier dossier, Prestation prestation) {
        this.dossier = dossier;
        this.prestation = prestation;
    }
}