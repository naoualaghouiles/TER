package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.PrestationsDto;
import br.com.ter.miage.entities.Prestation;

import java.text.ParseException;
import java.util.List;

public interface PrestationService {
    public void ajouterPrestations(Prestation prestation);

    List<Prestation> getAllPrestations();

    List<Prestation> getPrestationsByDesignationP(String designationP);
//    Prestations updatePrestations(String oldDesignationP, String newDesignationP);

    Prestation getPrestation(Long idPrestation);

    void deletePrestations(Long idPrestation);
    Prestation modifierPrestations(PrestationsDto prestationsDto) throws ParseException;

    Prestation addPrestations(PrestationsDto prestationsDto);



}
