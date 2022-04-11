package br.com.ter.miage.utilClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class RelationshipDossierSoins implements Serializable {

    @Column(name = "dossier_id")
    private Long dossierId;

    @Column(name = "soins_id")
    private Long soinsId;


}