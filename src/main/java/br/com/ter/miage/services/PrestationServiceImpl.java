package br.com.ter.miage.services;

import br.com.ter.miage.dto.PrestationsDto;
import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.repositories.PrestationRepository;
import br.com.ter.miage.services.interfaces.PrestationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class PrestationServiceImpl implements PrestationService {

    final
    PrestationRepository prestationRepository;

    public PrestationServiceImpl(PrestationRepository prestationRepository) {
        this.prestationRepository = prestationRepository;
    }


    @Override
    public void ajouterPrestations(Prestation prestation){
        prestationRepository.save(prestation);
    }

    @Override
    public List<Prestation> getAllPrestations() {

        return prestationRepository.findAll();
    }

    @Override
    public List<Prestation> getPrestationsByDesignationP(String designationP) {
        return prestationRepository.findPrestationsByDesignationP(designationP);
    }

    @Override
    public Prestation getPrestation(Long idPrestation) {
        return prestationRepository.getById(idPrestation);
    }

//    @Override
//    public Prestations updatePrestations(String oldDesignationP, String newDesignationP){
//        Prestations prestations = this.getPrestationsByDesignationP(oldDesignationP);
//
//        if (prestations != null) {
//            prestations.setDesignationP(newDesignationP);
//            prestationsRepository.save(prestations);
//            return prestations;
//        } else {
//            return null;
//        }
//
//    }


    @Transactional
    @Override
    public void deletePrestations(Long idPrestation) {

        prestationRepository.deletePrestations(idPrestation);
    }

    @Override
    public Prestation modifierPrestations(PrestationsDto prestationsDto) throws ParseException {
        Prestation prestation = prestationRepository.getById(prestationsDto.getIdPrestation());

        prestation.setDesignationP(prestationsDto.getDesignationP());

        return prestationRepository.save(prestation);

    }


    @Override
    public Prestation addPrestations(PrestationsDto prestationsDto) {

        Prestation prestation;

        prestation =new Prestation(
                prestationsDto.getDesignationP(),
                prestationsDto.getPrix()

        );

        return prestationRepository.save(prestation);

    }

}
