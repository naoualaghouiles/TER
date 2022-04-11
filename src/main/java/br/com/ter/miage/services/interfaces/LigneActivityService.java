package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LigneActivity;

import java.util.List;

public interface LigneActivityService {
    public LigneActivity getLigneActivityById(Long idLigneActivity);
    List<LigneActivity> getAllLigneActivity();
    LigneActivity ajouterLigneAcitivy(LigneActivity ligneActivity);
    void deleteLigneActivity(Long idLigneActivity);

    Boolean existsBy(Activity activity, Facture facture);

    void deleteLigneBy(Long idActivity, Long idFacture);
}
