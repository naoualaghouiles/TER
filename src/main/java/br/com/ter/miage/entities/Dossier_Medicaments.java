package br.com.ter.miage.entities;

import br.com.ter.miage.utilClass.RelationshipDossierMedicaments;
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
public class Dossier_Medicaments implements Serializable {

    @EmbeddedId
    private RelationshipDossierMedicaments id = new RelationshipDossierMedicaments();

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("dossierId")
    private Dossier dossier;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("medicamentsId")
    private Medicaments medicaments;


    public Dossier_Medicaments(Dossier dossier, Medicaments medicaments) {
        this.dossier = dossier;
        this.medicaments = medicaments;
    }
}