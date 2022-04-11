package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.entities.Maladie;

public interface MaladieService {

    void saveMaladie(Maladie maladie);

    void deleteMaladie(Long idMaladie);
    Maladie getMaladieByIdMaladie(Long idMaladie);

    Maladie getMaladieByDescription(String description);
}
