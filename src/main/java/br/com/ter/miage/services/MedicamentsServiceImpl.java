package br.com.ter.miage.services;


import br.com.ter.miage.dto.MedicamentsDto;
import br.com.ter.miage.dto.PrestationsDto;
import br.com.ter.miage.entities.Medicaments;
import br.com.ter.miage.entities.Prestation;
import br.com.ter.miage.repositories.MedicamentsRepository;
import br.com.ter.miage.services.interfaces.MedicamentsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class MedicamentsServiceImpl  implements MedicamentsService {

    final
    MedicamentsRepository medicamentsRepository;


    public MedicamentsServiceImpl(MedicamentsRepository medicamentsRepository) {
        this.medicamentsRepository = medicamentsRepository;
    }

    @Override
    public void ajouterMedicaments(Medicaments medicaments) {

        medicamentsRepository.save(medicaments);
    }

    @Override
    public List<Medicaments> getAllMedicaments() {

        return medicamentsRepository.findAll();
    }

    @Override
    public List<Medicaments> getMedicamentsByDesignationMed(String designationMed) {
        return medicamentsRepository.findMedicamentsByDesignationMed(designationMed);
    }

    @Override
    public Medicaments getMedicamentsByIdMedicaments(Long idMedicaments) {
        return medicamentsRepository.findMedicamentsByIdMedicaments(idMedicaments);
    }

//    @Override
//    public Medicaments updateMedicaments(String oldDesignationMed, String newDesignationMed) {
//        Medicaments medicaments = this.getMedicamentsByDesignationMed(oldDesignationMed);
//
//        if (medicaments != null) {
//            medicaments.setDesignationMed(newDesignationMed);
//            medicamentsRepository.save(medicaments);
//            return medicaments;
//        } else {
//            return null;
//        }
//    }

    @Transactional
    @Override
    public void deleteMedicaments(Long idMedicaments) {
        medicamentsRepository.deleteMedicaments(idMedicaments);
    }

    @Override
    public Medicaments modifierMedicaments(MedicamentsDto medicamentsDto) throws ParseException {
        Medicaments medicaments = medicamentsRepository.getById(medicamentsDto.getIdMedicaments());

        medicaments.setDesignationMed(medicamentsDto.getDesignationMed());
        return medicamentsRepository.save(medicaments);

    }


    @Override
    public Medicaments addMedicaments(MedicamentsDto medicamentsDto) {

        Medicaments medicaments;

        medicaments =new Medicaments(
                medicamentsDto.getDesignationMed()


        );

        return medicamentsRepository.save(medicaments);

    }
}
