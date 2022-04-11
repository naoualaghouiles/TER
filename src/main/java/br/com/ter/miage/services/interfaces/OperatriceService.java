package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.OperatriceDto;
import br.com.ter.miage.entities.Operatrice;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;

public interface OperatriceService extends UserDetailsService {

    List<Operatrice> getAllOperatrice();
    Operatrice getOperatriceByIdOperatrice(Long idOperatrice);
    Operatrice modifierOperatrice(OperatriceDto operatriceDto) throws ParseException;


    void deleteOperatrice(Long idOperatrice);
    Operatrice addOperatrice(OperatriceDto operatriceDto);
}

