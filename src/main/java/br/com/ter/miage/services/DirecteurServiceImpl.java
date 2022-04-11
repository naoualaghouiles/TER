package br.com.ter.miage.services;

import br.com.ter.miage.dto.DirecteurDto;
import br.com.ter.miage.entities.Directeur;
import br.com.ter.miage.repositories.DirecteurRepository;
import br.com.ter.miage.services.interfaces.DirecteurService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;


@Service
public class DirecteurServiceImpl  implements DirecteurService {

    final
    DirecteurRepository directeurRepository;

    public DirecteurServiceImpl(DirecteurRepository directeurRepository) {
        this.directeurRepository = directeurRepository;
    }

    @Override
    public  void ajouterDirecteur(Directeur directeur){
        directeurRepository.save(directeur);
    }

    @Override
    public List<Directeur> getAllDirecteurs(){
        return directeurRepository.findAll();
    }


    @Override
    public List<Directeur> getDirecteurByNom(String nom){
        return directeurRepository.findDirecteurByNom(nom);
    }

    @Override
    public Directeur getDirecteurById(Long idDirecteur){

        return directeurRepository.findDirecteurByIdDirecteur(idDirecteur);
    }


    @Override
    public Directeur modifierDirecteur(DirecteurDto directeurDto) throws ParseException {
        Directeur directeur = directeurRepository.getById(directeurDto.getIdDirecteur());

        directeur.setEmail(directeurDto.getEmail());
        directeur.setNom(directeurDto.getNom());
        directeur.setPrenom(directeurDto.getPrenom());


        return directeurRepository.save(directeur);

    }

    @Override
    public Directeur addDirecteur(DirecteurDto directeurDto) {

      Directeur directeur = null;

        directeur = new Directeur(
                directeurDto.getNom(),
                directeurDto.getPrenom(),
                directeurDto.getEmail()
        );
        return directeurRepository.save(directeur);

    }


    @Transactional
    @Override
    public void deleteDirecteur(Long idDirecteur) {
        directeurRepository.deleteDirecteur(idDirecteur);
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return directeurRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException(
                        "User not found"));
    }
}
