package br.com.ter.miage.services;


import br.com.ter.miage.entities.*;
import br.com.ter.miage.repositories.LigneActivityRepository;
import br.com.ter.miage.services.interfaces.ActivityService;
import br.com.ter.miage.services.interfaces.FactureService;
import br.com.ter.miage.services.interfaces.LigneActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LigneActivityServiceImpl implements LigneActivityService {

    final
    LigneActivityRepository ligneActivityRepository;

    final
    ActivityService activityService;

    final
    FactureService factureService;

    public LigneActivityServiceImpl(LigneActivityRepository ligneActivityRepository, ActivityService activityService, FactureService factureService) {
        this.ligneActivityRepository = ligneActivityRepository;
        this.activityService = activityService;
        this.factureService = factureService;
    }

    @Override
    public LigneActivity ajouterLigneAcitivy(LigneActivity ligneActivity) {

        return ligneActivityRepository.save(ligneActivity);
    }

    @Override
    public List<LigneActivity> getAllLigneActivity() {

        return ligneActivityRepository.findAll();
    }

    @Override
    public LigneActivity getLigneActivityById(Long idLigneActivity) {
        return ligneActivityRepository.findLigneActivityByIdLigneActivity(idLigneActivity);
    }


    @Transactional
    @Override
    public void deleteLigneActivity(Long idLigneActivity) {
        ligneActivityRepository.deleteLigneActivity(idLigneActivity);
    }

    @Override
    public Boolean existsBy(Activity activity, Facture facture) {

        return ligneActivityRepository.existsByActivityAndFacture(activity, facture);

    }

    @Override
    public void deleteLigneBy(Long idActivity, Long idFacture) {

        Activity activity = activityService.getActivity(idActivity);
        Facture facture = factureService.getById(idFacture);

        LigneActivity ligneActivity = ligneActivityRepository.findByActivityAndFacture(activity, facture);

        if (ligneActivity != null) {
            ligneActivityRepository.deleteLigneActivity(ligneActivity.getIdLigneActivity());
        }
    }
}
