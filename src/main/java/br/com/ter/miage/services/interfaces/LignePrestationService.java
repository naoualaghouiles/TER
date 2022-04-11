package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LignePrestation;
import br.com.ter.miage.entities.Prestation;

import java.util.List;

public interface LignePrestationService {
    public LignePrestation getLignePrestationById(Long idLignePrestation);
    List<LignePrestation> getAllLignePrestation();
    void ajouterLignePrestation(LignePrestation lignePrestation);
    void deleteLignePrestation(Long idLignePrestation);


    Boolean existsBy(Prestation prestation, Facture facture);

    void deleteLigneBy(Long idPrestation, Long idFacture);
}
