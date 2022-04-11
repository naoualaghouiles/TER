package br.com.ter.miage.services;

import br.com.ter.miage.entities.Gir;
import br.com.ter.miage.repositories.GirRepository;
import br.com.ter.miage.services.interfaces.GirService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirServiceImpl  implements GirService {

    final
    GirRepository girRepository;

    public GirServiceImpl(GirRepository girRepository) {
        this.girRepository = girRepository;
    }

    @Override
    public Gir getGirById(Long idGir) {
        if (girRepository.existsById(idGir)) {
            return girRepository.getById(idGir);
        } else {
            return null;
        }
    }




    @Transactional
    @Override
    public void deleteGir(Long idGir) {
        girRepository.deleteGir(idGir);
    }

}
