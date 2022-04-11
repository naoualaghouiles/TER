package br.com.ter.miage.services;


import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.entities.Facture;
import br.com.ter.miage.entities.LignePrestation;
import br.com.ter.miage.repositories.LignePrestationRepository;
import br.com.ter.miage.services.interfaces.FactureService;
import br.com.ter.miage.services.interfaces.LignePrestationService;
import br.com.ter.miage.services.interfaces.PrestationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LignePrestationServiceImpl implements LignePrestationService {

    final
    LignePrestationRepository lignePrestationRepository;

    final
    PrestationService prestationService;

    final
    FactureService factureService;

    public LignePrestationServiceImpl(LignePrestationRepository lignePrestationRepository, PrestationService prestationService, FactureService factureService) {
        this.lignePrestationRepository = lignePrestationRepository;
        this.prestationService = prestationService;
        this.factureService = factureService;
    }

    @Override
    public void ajouterLignePrestation(LignePrestation lignePrestation) {

        lignePrestationRepository.save(lignePrestation);
    }

    @Override
    public List<LignePrestation> getAllLignePrestation() {

        return lignePrestationRepository.findAll();
    }

    @Override
    public LignePrestation getLignePrestationById(Long idLignePrestation) {
        return lignePrestationRepository.findLignePrestationByIdLignePrestation(idLignePrestation);
    }


    @Transactional
    @Override
    public void deleteLignePrestation(Long idLignePrestation) {
        lignePrestationRepository.deleteLignePrestation(idLignePrestation);
    }

    @Override
    public Boolean existsBy(Prestation prestation, Facture facture) {

        return lignePrestationRepository.existsByPrestationAndFacture(prestation, facture);

    }

    @Override
    public void deleteLigneBy(Long idPrestation, Long idFacture) {

        Prestation prestation = prestationService.getPrestation(idPrestation);
        Facture facture = factureService.getById(idFacture);

        LignePrestation lignePrestation = lignePrestationRepository.findByPrestationAndFacture(prestation, facture);

        if (lignePrestation != null) {
            lignePrestationRepository.deleteLignePrestation(lignePrestation.getIdLignePrestation());
        }
    }
}
