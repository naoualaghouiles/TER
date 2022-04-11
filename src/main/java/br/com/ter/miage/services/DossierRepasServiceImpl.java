package br.com.ter.miage.services;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Repas;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.entities.Repas;
import br.com.ter.miage.repositories.Dossier_Repas_Repository;
import br.com.ter.miage.services.interfaces.DossierRepasService;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierRepasServiceImpl implements DossierRepasService {

    final
    Dossier_Repas_Repository dossierRepasRepository;

    final
    DossierService dossierService;

    public DossierRepasServiceImpl(Dossier_Repas_Repository dossierRepasRepository, DossierService dossierService) {
        this.dossierRepasRepository = dossierRepasRepository;
        this.dossierService = dossierService;
    }

    @Override
    public Dossier_Repas ajouter(Patient patient, Repas repas) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        Dossier_Repas dossier_repas = new Dossier_Repas(dossier, repas);


        return dossierRepasRepository.save(dossier_repas);
    }

    @Override
    public Boolean existsBy(Patient patient, Repas repas) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        return dossierRepasRepository.existsByDossierAndRepas(dossier, repas);
    }

    @Override
    public List<Repas> getPatientRepas(Patient patient) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        List<Dossier_Repas> dossierRepasList = dossierRepasRepository.findAllByDossier(dossier);

        List<Repas> repasList = new ArrayList<>();

        for (Dossier_Repas dossier_repas :
                dossierRepasList) {
            repasList.add(dossier_repas.getRepas());
        }

        return repasList;

    }

    @Override
    public void deleteDossierRepas(Patient patient, Repas repas) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        dossierRepasRepository.deleteRelation(repas, dossier);
    }
}
