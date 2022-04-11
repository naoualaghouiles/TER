package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    Optional<Patient> findByEmail(String email);
    List<Patient> findPatientByNom(String nom);
    List<Patient> findPatientByPrenom(String prenom);
    List<Patient> findPatientBySexe(String sexe);
    List<Patient> findPatientByAdresse(String adresse);
    List<Patient> findPatientByDateEntree(Date dateEntree);
    Patient findPatientByNumTel(String numTel);
    List<Patient> findPatientByDateNaissance(Date dateNaissance);

    List<Patient> findByNomStartingWithIgnoreCase(String nom);

    @Transactional
    @Modifying
    @Query("delete from Patient p where p.idPatient=:idPatient")
    void deletePatient(@Param("idPatient") Long idPatient);


}