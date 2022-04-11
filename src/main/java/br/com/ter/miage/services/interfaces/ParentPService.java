package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.ParentDto;
import br.com.ter.miage.entities.ParentP;

import java.text.ParseException;
import java.util.List;

public interface ParentPService {
    void ajouterParentP(ParentP parentP);
    List<ParentP> getAllParentP();
    ParentP getParentPByEmailI(String emailP);
    List<ParentP> getParentPByNomP(String nomP);
    List<ParentP> getParentPByPrenomP(String prenomP);
    ParentP getParentPByIdParentP(Long idParentP);
    ParentP modifierParentP(ParentDto parentDto) throws ParseException;
    void deleteParentP(Long idParentP);

    ParentP addParentP(ParentDto parentDto);
    ParentP modifierParent(ParentDto parentDto) throws ParseException;
}
