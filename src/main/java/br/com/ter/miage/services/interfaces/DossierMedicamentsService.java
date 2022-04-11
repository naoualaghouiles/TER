package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.*;

import java.util.List;

public interface DossierMedicamentsService {
    Dossier_Medicaments ajouter(Patient patient, Medicaments medicaments);

    Boolean existsBy(Patient patient, Medicaments medicaments);

    List<Medicaments> getPatientMedicaments(Patient patient);

    void deleteDossierMedicaments(Patient patient, Medicaments medicaments);
}
