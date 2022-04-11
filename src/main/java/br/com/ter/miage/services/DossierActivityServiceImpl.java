package br.com.ter.miage.services;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.repositories.Dossier_Activity_Repository;
import br.com.ter.miage.services.interfaces.DossierActivityService;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DossierActivityServiceImpl implements DossierActivityService{

    final
    Dossier_Activity_Repository dossierActivityRepository;

    final
    DossierService dossierService;


    public DossierActivityServiceImpl(Dossier_Activity_Repository dossierActivityRepository, DossierService dossierService) {
        this.dossierActivityRepository = dossierActivityRepository;
        this.dossierService = dossierService;
    }

    @Override
    public Dossier_Activity ajouter(Patient patient, Activity activity) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        Dossier_Activity dossier_activity = new Dossier_Activity(dossier, activity);


        return dossierActivityRepository.save(dossier_activity);
    }

    @Override
    public Boolean existsBy(Patient patient, Activity activity) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        return dossierActivityRepository.existsByDossierAndActivity(dossier, activity);
    }

    @Override
    public List<Activity> getPatientActivity(Patient patient) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        List<Dossier_Activity> dossierActivityList = dossierActivityRepository.findAllByDossier(dossier);

        List<Activity> activityList = new ArrayList<>();

        for (Dossier_Activity dossier_activity :
                dossierActivityList) {
            activityList.add(dossier_activity.getActivity());
        }

        return activityList;

    }

    @Override
    public void deleteDossierActivity(Patient patient, Activity activity) {
        Dossier dossier = dossierService.getDossierByPatient(patient);

        dossierActivityRepository.deleteRelation(activity, dossier);
    }
}
