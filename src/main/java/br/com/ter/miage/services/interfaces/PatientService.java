package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.AjoutPatientDto;
import br.com.ter.miage.entities.Patient;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.text.ParseException;
import java.util.List;

public interface PatientService extends UserDetailsService {
//    void saveUser(PatientDto patientDto);
    List<Patient> getAllPatients();

    Patient addPatient(AjoutPatientDto ajoutPatientDto);

    void deletePatientById(Long idPatient);

    Patient getPatientById(Long idPatient);

    Patient modifierPatient(AjoutPatientDto ajoutPatientDto) throws ParseException;

    List<Patient> searchForPatients(String nom);
}
