package br.com.ter.miage.services;

import br.com.ter.miage.dto.AjoutPatientDto;
import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Patient;
import br.com.ter.miage.repositories.PatientRepository;
import br.com.ter.miage.services.interfaces.DossierService;
import br.com.ter.miage.services.interfaces.GirService;
import br.com.ter.miage.services.interfaces.PatientService;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    final
    PatientRepository patientRepository;

    final
    GirService girService;

    final
    DossierService dossierService;

    final
    BCryptPasswordEncoder passwordEncoder;

    public PatientServiceImpl(PatientRepository patientRepository, @Lazy BCryptPasswordEncoder passwordEncoder, GirService girService, DossierService dossierService) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
        this.girService = girService;
        this.dossierService = dossierService;
    }


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return patientRepository.findByEmail(email).orElseThrow(() ->
                new UsernameNotFoundException(
                        "User not found"));
    }

//    @Override
//    public void saveUser(PatientDto patientDto) {
//        Patient patient = new Patient(patientDto.getNom(),
//                patientDto.getPrenom(),
//                patientDto.getEmail(),
//                patientDto.getSexe(),
//                patientDto.getDureeSejour(),
//                patientDto.getAdresse(),
//                passwordEncoder.encode(patientDto.getPassword())
//        );
//
//        patientRepository.save(patient);
//    }


    @Override
    public Patient addPatient(AjoutPatientDto ajoutPatientDto) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String dateNow = simpleDateFormat.format(new Date());

        Patient patient = null;

        try {
            Date dateEntree = simpleDateFormat.parse(dateNow);
            Date dateNaissance = simpleDateFormat.parse(ajoutPatientDto.getDateNaissance());


            patient = new Patient(
                    ajoutPatientDto.getNom(),
                    ajoutPatientDto.getPrenom(),
                    ajoutPatientDto.getSexe(),
                    ajoutPatientDto.getAdresse(),
                    new Date(),
                    ajoutPatientDto.getEmail(),
                    passwordEncoder.encode(
                            ajoutPatientDto.getPrenom().toLowerCase()
                                    + '.'
                                    + ajoutPatientDto.getNom().toLowerCase()),
                    ajoutPatientDto.getNumTel(),
                    dateNaissance

            );

            patient.setGir(girService.getGirById(ajoutPatientDto.getIdGir()));

        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        Patient patient1 = patientRepository.save(patient);

        if (patient1 != null) {
            Dossier dossier = dossierService.createDossier(patient1);

            if (dossier != null) {
                return patient1;
            } else {
               return null;
            }
        } else {
            return null;
        }


    }

    @Override
    public Patient getPatientById(Long idPatient) {
        return patientRepository.getById(idPatient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public void deletePatientById(Long idPatient) {
        patientRepository.deletePatient(idPatient);
    }

    @Override
    public Patient modifierPatient(AjoutPatientDto ajoutPatientDto) throws ParseException {
        Patient patient = patientRepository.getById(ajoutPatientDto.getIdPatient());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        patient.setPrenom(ajoutPatientDto.getPrenom());
        patient.setNom(ajoutPatientDto.getNom());
        patient.setEmail(ajoutPatientDto.getEmail());
        patient.setDateEntree(simpleDateFormat.parse(ajoutPatientDto.getDateEntree()));
        patient.setAdresse(ajoutPatientDto.getAdresse());
        patient.setNumTel(ajoutPatientDto.getNumTel());
        patient.setDateNaissance(simpleDateFormat.parse(ajoutPatientDto.getDateNaissance()));
        patient.setSexe(ajoutPatientDto.getSexe());
        patient.setGir(girService.getGirById(ajoutPatientDto.getIdGir()));

        return patientRepository.save(patient);

    }

    @Override
    public List<Patient> searchForPatients(String nom) {
        return patientRepository.findByNomStartingWithIgnoreCase(nom);
//        return null;
    }

}
