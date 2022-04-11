package br.com.ter.miage.services;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.repositories.Dossier_Activity_Repository;
import br.com.ter.miage.repositories.Dossier_Medicaments_Repository;
import br.com.ter.miage.services.interfaces.DossierActivityService;
import br.com.ter.miage.services.interfaces.DossierMedicamentsService;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierMedicamentsServiceImpl implements DossierMedicamentsService {

    final
    Dossier_Medicaments_Repository dossierMedicamentsRepository;

    final
    DossierService dossierService;


    public DossierMedicamentsServiceImpl(Dossier_Medicaments_Repository dossierMedicamentsRepository, DossierService dossierService) {
        this.dossierMedicamentsRepository = dossierMedicamentsRepository;
        this.dossierService = dossierService;
    }

    @Override
    public Dossier_Medicaments ajouter(Patient patient, Medicaments medicaments) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        Dossier_Medicaments dossier_medicaments = new Dossier_Medicaments(dossier, medicaments);


        return dossierMedicamentsRepository.save(dossier_medicaments);
    }

    @Override
    public Boolean existsBy(Patient patient, Medicaments medicaments) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        return dossierMedicamentsRepository.existsByDossierAndMedicaments(dossier, medicaments);
    }

    @Override
    public List<Medicaments> getPatientMedicaments(Patient patient) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        List<Dossier_Medicaments> dossierMedicamentsList = dossierMedicamentsRepository.findAllByDossier(dossier);

        List<Medicaments> medicamentsList = new ArrayList<>();

        for (Dossier_Medicaments dossier_medicaments :
                dossierMedicamentsList) {
            medicamentsList.add(dossier_medicaments.getMedicaments());
        }

        return medicamentsList;

    }

    @Override
    public void deleteDossierMedicaments(Patient patient, Medicaments medicaments) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        dossierMedicamentsRepository.deleteRelation(medicaments, dossier);
    }
}
