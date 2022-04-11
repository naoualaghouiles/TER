package br.com.ter.miage.services;


import br.com.ter.miage.dto.ParentDto;
import br.com.ter.miage.entities.ParentP;
import br.com.ter.miage.repositories.ParentPRepository;
import br.com.ter.miage.services.interfaces.ParentPService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class ParentPServiceImpl  implements ParentPService {

    final
    ParentPRepository parentPRepository;

    public ParentPServiceImpl(ParentPRepository parentPRepository) {
        this.parentPRepository = parentPRepository;
    }




    @Override
    public void ajouterParentP(ParentP parentP){
        parentPRepository.save(parentP);
    }

    @Override
    public List<ParentP> getAllParentP() {

        return parentPRepository.findAll();
    }

    @Override
    public ParentP getParentPByEmailI(String emailP) {
        return parentPRepository.findParentPByEmailP(emailP);
    }
    @Override
    public List<ParentP> getParentPByNomP(String nomP) {

        return parentPRepository.findParentPByNomP(nomP);
    }

    @Override
    public List<ParentP> getParentPByPrenomP(String prenomP) {
        return parentPRepository.findParentPByPrenomP(prenomP);
    }
    @Override
    public ParentP getParentPByIdParentP(Long idParentP) {
        return parentPRepository.findParentPByIdParentP(idParentP);
    }

    @Override
    public ParentP modifierParentP(ParentDto parentDto) throws ParseException {
        ParentP parentP = parentPRepository.getById(parentDto.getIdParentP());

        parentP.setEmailP(parentDto.getEmailP());
        parentP.setNomP(parentDto.getNomP());
        parentP.setPrenomP(parentDto.getPrenomP());
        parentP.setAdresseP(parentDto.getAdresseP());

        return parentPRepository.save(parentP);

    }

    @Transactional
    @Override
    public void deleteParentP(Long idParentP) {
        parentPRepository.deleteParentP(idParentP);
    }


    @Override
    public ParentP addParentP(ParentDto parentDto) {

        ParentP parentP;

        parentP=new ParentP(
                parentDto.getNomP(),
                parentDto.getPrenomP(),
                parentDto.getAdresseP(),
                parentDto.getEmailP()

        );

        return parentPRepository.save(parentP);

    }

    @Override
    public ParentP modifierParent(ParentDto parentDto) throws ParseException {
        ParentP parentP = parentPRepository.getById(parentDto.getIdParentP());

        parentP.setNomP(parentDto.getNomP());
        parentP.setPrenomP(parentDto.getPrenomP());
        parentP.setAdresseP(parentDto.getAdresseP());
        parentP.setEmailP(parentDto.getEmailP());


        return parentPRepository.save(parentP);

    }
}
