package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.*;

import java.util.List;

public interface DossierActivityService {
    Dossier_Activity ajouter(Patient patient, Activity activity);

    Boolean existsBy(Patient patient, Activity activity);

    List<Activity> getPatientActivity(Patient patient);

    void deleteDossierActivity(Patient patient, Activity activity);

}
