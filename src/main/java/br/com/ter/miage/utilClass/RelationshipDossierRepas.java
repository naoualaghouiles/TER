package br.com.ter.miage.utilClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@EqualsAndHashCode
@Embeddable
public class RelationshipDossierRepas implements Serializable {

    @Column(name = "dossier_id")
    private Long dossierId;

    @Column(name = "repas_id")
    private Long repasId;

    public Long getDossierId() {
        return dossierId;
    }

    public void setDossierId(Long dossierId) {
        this.dossierId = dossierId;
    }

    public Long getRepasId() {
        return repasId;
    }

    public void setRepasId(Long repasId) {
        this.repasId = repasId;
    }
}