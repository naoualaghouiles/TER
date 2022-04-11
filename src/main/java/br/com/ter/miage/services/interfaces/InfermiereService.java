package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.InfermiereDto;
import br.com.ter.miage.entities.Infermiere;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;

public interface InfermiereService extends UserDetailsService {
    UserDetails loadUserByUsername(String s);
    Infermiere getInfermiereByEmailI(String emailI);
    List<Infermiere> getInfermiereByNomI(String nomI);
    List<Infermiere> getInfermiereByPrenomI(String prenomI);
    Infermiere getInfermiereByIdInfermiere(Long idInfermiere);
    Infermiere modifierInfermiere(InfermiereDto infermiereDto) throws ParseException;
    void deleteInfermiere(Long idInfermiere);
    List<Infermiere> getAllInfermieres();
    void ajouterInfermiere(Infermiere infermiere);
    Infermiere addInfermiere(InfermiereDto infermiereDto);
}
