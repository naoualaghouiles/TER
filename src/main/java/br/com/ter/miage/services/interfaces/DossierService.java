package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Patient;

public interface DossierService {



    Dossier createDossier(Patient patient);

    Dossier getDossierById(Long id);

    Dossier getDossierByPatient(Patient patient);

    void deleteDossier(Long idDossier);
}
