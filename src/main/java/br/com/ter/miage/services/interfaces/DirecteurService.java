package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.DirecteurDto;
import br.com.ter.miage.entities.Directeur;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;

public interface DirecteurService extends UserDetailsService {

    void ajouterDirecteur(Directeur directeur);

    List<Directeur> getAllDirecteurs();

   List<Directeur> getDirecteurByNom(String nom);
    Directeur getDirecteurById(Long idDirecteur);
    Directeur modifierDirecteur(DirecteurDto directeurDto) throws ParseException;
    void deleteDirecteur(Long idDirecteur);
    Directeur addDirecteur(DirecteurDto directeurDto);
}
