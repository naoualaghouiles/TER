package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.*;

import java.util.List;

public interface DossierPrestationService {
    Dossier_Prestation ajouter(Patient patient, Prestation prestation);

    Boolean existsBy(Patient patient, Prestation prestation);

    List<Prestation> getPatientPrestation(Patient patient);

    void deleteDossierPrestation(Patient patient, Prestation prestation);
}
