package br.com.ter.miage.services;

import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Dossier_Prestation;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.repositories.Dossier_Prestation_Repository;
import br.com.ter.miage.services.interfaces.DossierPrestationService;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierPrestationServiceImpl implements DossierPrestationService {

    final
    Dossier_Prestation_Repository dossierPrestationRepository;

    final
    DossierService dossierService;


    public DossierPrestationServiceImpl(Dossier_Prestation_Repository dossierPrestationRepository, DossierService dossierService) {
        this.dossierPrestationRepository = dossierPrestationRepository;
        this.dossierService = dossierService;
    }

    @Override
    public Dossier_Prestation ajouter(Patient patient, Prestation prestation) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        Dossier_Prestation dossier_prestation = new Dossier_Prestation(dossier, prestation);


        return dossierPrestationRepository.save(dossier_prestation);
    }

    @Override
    public Boolean existsBy(Patient patient, Prestation prestation) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        return dossierPrestationRepository.existsByDossierAndPrestation(dossier, prestation);
    }

    @Override
    public List<Prestation> getPatientPrestation(Patient patient) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        List<Dossier_Prestation> dossierPrestationList = dossierPrestationRepository.findAllByDossier(dossier);

        List<Prestation> prestationList = new ArrayList<>();

        for (Dossier_Prestation dossier_prestation :
                dossierPrestationList) {
            prestationList.add(dossier_prestation.getPrestation());
        }

        return prestationList;

    }

    @Override
    public void deleteDossierPrestation(Patient patient, Prestation prestation) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        dossierPrestationRepository.deleteRelation(prestation, dossier);
    }
}
