package br.com.ter.miage.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class LigneActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLigneActivity;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idActivity",nullable = false)
    private Activity activity;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idFacture",nullable = false)
    private Facture facture;

    public LigneActivity(Activity activity, Facture facture) {
        this.activity = activity;
        this.facture = facture;
    }
}
