package br.com.ter.miage.services.interfaces;


import br.com.ter.miage.dto.AjoutRepasDto;
import br.com.ter.miage.dto.RepasDto;
import br.com.ter.miage.entities.Repas;

import java.text.ParseException;
import java.util.List;

public interface RepasService {
    void ajouterRepas(Repas repas);

    List<Repas> getAllRepas();

    Repas getRepasByDesignation(String designation);

//    Repas updateRepas(String oldDesignation, String newDesignation);

    void deleteRepas(Long idRepas);
    Repas modifierRepas(RepasDto repasDto) throws ParseException;
//    Repas addRepas(RepasDto repasDto);

    Repas addRepas(AjoutRepasDto ajoutRepasDto);

    Repas getRepasById(Long idRepas);
}
