package br.com.ter.miage.services;


import br.com.ter.miage.dto.InfermiereDto;

import br.com.ter.miage.entities.Infermiere;
import br.com.ter.miage.repositories.InfermiereRepository;
import br.com.ter.miage.services.interfaces.InfermiereService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class InfermiereServiceImlp  implements InfermiereService {

    final
    InfermiereRepository infermiereRepository;

    public InfermiereServiceImlp(InfermiereRepository infermiereRepository) {
        this.infermiereRepository = infermiereRepository;
    }




    @Override
    public void ajouterInfermiere(Infermiere infermiere){

        infermiereRepository.save(infermiere);
    }

    @Override
    public List<Infermiere> getAllInfermieres() {

        return infermiereRepository.findAll();
    }

    @Override
    public Infermiere getInfermiereByEmailI(String emailI) {
        return infermiereRepository.findInfermiereByEmail(emailI);
    }

    @Override
    public List<Infermiere> getInfermiereByNomI(String nomI) {

        return infermiereRepository.findInfermiereByNom(nomI);
    }

    @Override
    public List<Infermiere> getInfermiereByPrenomI(String prenomI) {
        return infermiereRepository.findInfermiereByPrenom(prenomI);
    }
    @Override
    public Infermiere getInfermiereByIdInfermiere(Long idInfermiere) {
        return infermiereRepository.findInfermiereByIdInfermiere(idInfermiere);
    }

    @Override
    public Infermiere modifierInfermiere(InfermiereDto infermiereDto) throws ParseException {
        Infermiere infermiere = infermiereRepository.getById(infermiereDto.getIdInfermiere());

       infermiere.setEmail(infermiereDto.getEmailI());
       infermiere.setNom(infermiereDto.getNomI());
       infermiere.setPrenom(infermiereDto.getPrenomI());

        return infermiereRepository.save(infermiere);

    }

    @Transactional
    @Override
    public void deleteInfermiere(Long idInfermiere) {
        infermiereRepository.deleteInfermiere(idInfermiere);
    }


    @Override
    public Infermiere addInfermiere(InfermiereDto infermiereDto) {

        Infermiere infermiere = null;

        infermiere = new Infermiere(
                infermiereDto.getNomI(),
                infermiereDto.getPrenomI(),
                infermiereDto.getEmailI()
        );
        return infermiereRepository.save(infermiere);

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return infermiereRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException(
                        "User not found"));
    }
}
