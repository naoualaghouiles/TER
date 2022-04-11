package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Repas;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.entities.Repas;

import java.util.List;

public interface DossierRepasService {


    Dossier_Repas ajouter(Patient patient, Repas repas);

    Boolean existsBy(Patient patient, Repas repas);

    List<Repas> getPatientRepas(Patient patient);


    void deleteDossierRepas(Patient patient, Repas repas);
}
