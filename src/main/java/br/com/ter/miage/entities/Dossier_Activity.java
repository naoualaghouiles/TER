package br.com.ter.miage.entities;

import br.com.ter.miage.utilClass.RelationshipDossierActivity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Dossier_Activity implements Serializable {

    @EmbeddedId
    private RelationshipDossierActivity id = new RelationshipDossierActivity();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dossierId")
    private Dossier dossier;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("activityId")
    private Activity activity;


    public Dossier_Activity(Dossier dossier, Activity activity) {
        this.dossier = dossier;
        this.activity = activity;
    }
}