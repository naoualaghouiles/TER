package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.entities.Prestation;

import java.util.Date;
import java.util.List;

public interface FactureService {

    Facture ajouterFacture(Facture facture);

    Facture getById(Long idFacture);

    List<Facture> getAllFactures();

    List<Facture> getFactureByEtat(String etat);

    List<Facture> getFactureByDateF(Date dateF);

    void deleteFacture(Long idFacture);

    void updatePrixFactures(Patient patient);

//    int getNombreDeJourSejour(Patient patient);
//
//    double getPrixSejour(Patient patient);

    int getJourSejour(List<Activity> activityList, List<Prestation> prestationList, Facture facture);
}
