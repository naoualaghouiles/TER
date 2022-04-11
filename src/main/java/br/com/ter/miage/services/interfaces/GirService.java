package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Gir;

public interface GirService {
    Gir getGirById(Long idGir);
    void deleteGir(Long idGir);
}
