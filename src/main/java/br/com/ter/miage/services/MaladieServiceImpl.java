package br.com.ter.miage.services;

import br.com.ter.miage.entities.Maladie;
import br.com.ter.miage.repositories.MaladieRepository;
import br.com.ter.miage.services.interfaces.MaladieService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MaladieServiceImpl implements MaladieService {

    final
    MaladieRepository maladieRepository;

    public MaladieServiceImpl(MaladieRepository maladieRepository) {
        this.maladieRepository = maladieRepository;
    }

    @Override
    public void saveMaladie(Maladie maladie) {
        maladieRepository.save(maladie);
    }

    @Override
    public Maladie getMaladieByDescription(String description) {
        return maladieRepository.findMaladieByDescription(description);
    }


    @Override
    public Maladie getMaladieByIdMaladie(Long idMaladie) {
        return maladieRepository.findMaladieByIdMaladie(idMaladie);
    }
    @Transactional
    @Override
    public void deleteMaladie(Long idMaladie) {
        maladieRepository.deleteMaladie(idMaladie);
    }
}
