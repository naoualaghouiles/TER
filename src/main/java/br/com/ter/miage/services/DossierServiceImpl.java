package br.com.ter.miage.services;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.repositories.DossierRepository;
import br.com.ter.miage.services.interfaces.DossierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DossierServiceImpl implements DossierService {

    final
    DossierRepository dossierRepository;

    public DossierServiceImpl(DossierRepository dossierRepository) {
        this.dossierRepository = dossierRepository;
    }

//    @Override
//    public void ajouterDossier(Dossier dossier) {
//        dossierRepository.save(dossier);
//    }


    @Override
    public Dossier createDossier(Patient patient) {
        Dossier dossier = new Dossier(patient);

        return dossierRepository.save(dossier);
    }
    @Override
    public Dossier getDossierById(Long id) {
        if (dossierRepository.existsByIdDossier(id)) {
            return dossierRepository.findById(id).get();
        }
        return null;
    }

    @Override
    public Dossier getDossierByPatient(Patient patient) {
        return dossierRepository.findDossierByPatient(patient);
    }



    @Transactional
    @Override
    public void deleteDossier(Long idDossier) {
        dossierRepository.deleteDossier(idDossier);
    }


}
