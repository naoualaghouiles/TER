package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.SoinsDto;
import br.com.ter.miage.entities.Soins;

import java.text.ParseException;
import java.util.List;

public interface SoinsService {

     void ajouterSoins(Soins soins);
    List<Soins> getAllSoins();

    List<Soins> getSoinsByDesignationS(String designationS);

//    Soins updateSoins(String oldDesignationS, String newDesignationS);

    void deleteSoins(Long idSoin);

    Soins addSoin(SoinsDto soinsDto);

    Soins modifierSoins(SoinsDto soinsDto) throws ParseException;

    Soins getSoins(Long idSoins);
}
