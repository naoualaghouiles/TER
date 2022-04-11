package br.com.ter.miage.services;


import br.com.ter.miage.dto.ActiviteDto;
import br.com.ter.miage.dto.AjoutPatientDto;
import br.com.ter.miage.dto.SoinsDto;
import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.entities.Soins;
import br.com.ter.miage.repositories.SoinsRepository;
import br.com.ter.miage.services.interfaces.SoinsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SoinsServiceImpl implements SoinsService {

    final
    SoinsRepository soinsRepository;

    public SoinsServiceImpl(SoinsRepository soinsRepository) {
        this.soinsRepository = soinsRepository;
    }

    @Override
    public void ajouterSoins(Soins soins) {
        soinsRepository.save(soins);

    }

    @Override
    public List<Soins> getAllSoins() {

        return soinsRepository.findAll();
    }

    @Override
    public List<Soins> getSoinsByDesignationS(String designationS) {
        return soinsRepository.findSoinsByDesignationS(designationS);
    }





    @Override
    public Soins addSoin(SoinsDto soinsDto) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");


        Soins soins;
        try {

            Date date = simpleDateFormat.parse(soinsDto.getDate());

            soins =new Soins(

                    soinsDto.getDesignationS(),
                    date,
                    soinsDto.getCommentaire()

            );


        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return soinsRepository.save(soins);

    }
//    @Override
//    public Soins updateSoins(String oldDesignationS, String newDesignationS){
//        Soins soins = this.getSoinsByDesignationS(oldDesignationS);
//
//        if (soins != null) {
//            soins.setDesignationS(newDesignationS);
//            soinsRepository.save(soins);
//            return soins;
//        } else {
//            return null;
//        }
//    }

    @Override
    public Soins modifierSoins(SoinsDto soinsDto) throws ParseException {
        Soins soins = soinsRepository.getById(soinsDto.getIdSoin());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        soins.setDesignationS(soinsDto.getDesignationS());
        soins.setCommentaire(soinsDto.getCommentaire());
        soins.setDate(simpleDateFormat.parse(soinsDto.getDate()));

        return soinsRepository.save(soins);

    }






    @Transactional
    @Override
    public void deleteSoins(Long idSoin) {
        soinsRepository.deleteSoins(idSoin);
    }


    @Override
    public Soins getSoins(Long idSoins) {
        return soinsRepository.findSoinsByIdSoin(idSoins);
    }
}
