package br.com.ter.miage.services;

import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Soins;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.repositories.Dossier_Soins_Repository;
import br.com.ter.miage.services.interfaces.DossierSoinsService;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierSoinsServiceImpl implements DossierSoinsService{

    final
    Dossier_Soins_Repository dossierSoinsRepository;

    final
    DossierService dossierService;


    public DossierSoinsServiceImpl(Dossier_Soins_Repository dossierSoinsRepository, DossierService dossierService) {
        this.dossierSoinsRepository = dossierSoinsRepository;
        this.dossierService = dossierService;
    }

    @Override
    public Dossier_Soins ajouter(Patient patient, Soins soins) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        Dossier_Soins dossier_soins = new Dossier_Soins(dossier, soins);


        return dossierSoinsRepository.save(dossier_soins);
    }

    @Override
    public Boolean existsBy(Patient patient, Soins soins) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        return dossierSoinsRepository.existsByDossierAndSoins(dossier, soins);
    }

    @Override
    public List<Soins> getPatientSoins(Patient patient) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        List<Dossier_Soins> dossierSoinsList = dossierSoinsRepository.findAllByDossier(dossier);

        List<Soins> soinsList = new ArrayList<>();

        for (Dossier_Soins dossier_soins :
                dossierSoinsList) {
            soinsList.add(dossier_soins.getSoins());
        }

        return soinsList;

    }

    @Override
    public void deleteDossierSoins(Patient patient, Soins soins) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        dossierSoinsRepository.deleteRelation(soins, dossier);
    }
}
