package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Dossier_Soins;
import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.entities.Patient;

import java.util.List;

public interface DossierSoinsService {
    Dossier_Soins ajouter(Patient patient, Soins soins);

    Boolean existsBy(Patient patient, Soins soins);

    List<Soins> getPatientSoins(Patient patient);

    void deleteDossierSoins(Patient patient, Soins soins);
}
