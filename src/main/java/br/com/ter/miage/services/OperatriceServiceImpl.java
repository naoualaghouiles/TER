package br.com.ter.miage.services;

import br.com.ter.miage.dto.OperatriceDto;
import br.com.ter.miage.entities.Operatrice;
import br.com.ter.miage.repositories.OperatriceRepository;
import br.com.ter.miage.services.interfaces.OperatriceService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;


@Service
public class OperatriceServiceImpl  implements OperatriceService {

    final
    OperatriceRepository operatriceRepository;

    final
    BCryptPasswordEncoder passwordEncoder;

    public OperatriceServiceImpl(OperatriceRepository operatriceRepository, @Lazy BCryptPasswordEncoder passwordEncoder) {
        this.operatriceRepository = operatriceRepository;
        this.passwordEncoder = passwordEncoder;
    }




    @Override
    public List<Operatrice> getAllOperatrice() {

        return operatriceRepository.findAll();
    }

    @Override
    public Operatrice getOperatriceByIdOperatrice(Long idOperatrice) {
        return operatriceRepository.findOperatriceByIdOperatrice(idOperatrice);
    }



    @Override
    public Operatrice modifierOperatrice(OperatriceDto operatriceDto) throws ParseException {
        Operatrice operatrice = operatriceRepository.getById(operatriceDto.getIdOperatrice());

       operatrice.setNom(operatriceDto.getNom());
       operatrice.setPrenom(operatriceDto.getPrenom());
       operatrice.setEmail(operatriceDto.getEmail());

        return operatriceRepository.save(operatrice);

    }

    @Override
    public Operatrice addOperatrice(OperatriceDto operatriceDto) {

        Operatrice operatrice = null;

        operatrice = new Operatrice(
                operatriceDto.getNom(),
                operatriceDto.getPrenom(),
                operatriceDto.getEmail(),
                passwordEncoder.encode(
                        operatriceDto.getPrenom().toLowerCase()
                                + '.'
                                + operatriceDto.getNom().toLowerCase())
        );
        return operatriceRepository.save(operatrice);

    }

    @Transactional
    @Override
    public void deleteOperatrice(Long idOperatrice) {
        operatriceRepository.deleteOperatrice(idOperatrice);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return operatriceRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                        "User not found"));
    }
}
