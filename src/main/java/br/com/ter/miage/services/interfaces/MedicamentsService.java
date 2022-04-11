package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.MedicamentsDto;
import br.com.ter.miage.entities.Medicaments;

import java.text.ParseException;
import java.util.List;

public interface MedicamentsService {

    void ajouterMedicaments(Medicaments medicaments);

    List<Medicaments> getAllMedicaments();

    List<Medicaments> getMedicamentsByDesignationMed(String designationMed);
//    public Medicaments updateMedicaments(String oldDesignationMed, String newDesignationMed);
    void deleteMedicaments(Long idMedicaments);
    Medicaments modifierMedicaments(MedicamentsDto medicamentsDto) throws ParseException;
    Medicaments getMedicamentsByIdMedicaments(Long idMedicaments);


    Medicaments addMedicaments(MedicamentsDto medicamentsDto);
}
