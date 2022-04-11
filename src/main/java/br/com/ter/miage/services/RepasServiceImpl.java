package br.com.ter.miage.services;

import br.com.ter.miage.dto.AjoutRepasDto;
import br.com.ter.miage.dto.RepasDto;
import br.com.ter.miage.entities.Repas;
import br.com.ter.miage.repositories.RepasRepository;
import br.com.ter.miage.services.interfaces.RepasService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class RepasServiceImpl implements RepasService {

    final
    RepasRepository repasRepository;

    public RepasServiceImpl(RepasRepository repasRepository) {
        this.repasRepository = repasRepository;
    }

    @Override
    public void ajouterRepas(Repas repas) {

        repasRepository.save(repas);
    }

    @Override
    public List<Repas> getAllRepas() {

        return repasRepository.findAll();
    }

    @Override
    public Repas getRepasByDesignation(String designation) {
        return repasRepository.findRepasByDesignation(designation);
    }

//    @Override
//    public Repas updateRepas(String oldDesignation, String newDesignation){
//        Repas repas = this.getRepasByDesignation(oldDesignation);
//
//        if (repas != null) {
//            repas.setDesignation(newDesignation);
//            repasRepository.save(repas);
//            return repas;
//        } else {
//            return null;
//        }
//    }

    @Transactional
    @Override
    public void deleteRepas(Long idRepas) {
        repasRepository.deleteRepas(idRepas);
    }

    @Override
    public Repas modifierRepas(RepasDto repasDto) throws ParseException {
        Repas repas = repasRepository.getById(repasDto.getIdRepas());

       repas.setDesignation(repasDto.getDesignation());

        return repasRepository.save(repas);

    }

//
//    @Override
//    public Repas addRepas(RepasDto repasDto) {
//
//        Repas repas;
//
//        repas=new Repas(
//                repasDto.getDesignation()
//
//        );
//
//        return repasRepository.save(repas);
//
//    }


    @Override
    public Repas addRepas(AjoutRepasDto ajoutRepasDto) {
        Repas repas = new Repas(ajoutRepasDto.getDesignation(), ajoutRepasDto.getPhoto());

        return repasRepository.save(repas);
    }

    @Override
    public Repas getRepasById(Long idRepas) {
        return repasRepository.getById(idRepas);
    }
}
