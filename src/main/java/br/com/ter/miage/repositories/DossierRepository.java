package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Dossier;
import br.com.ter.miage.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DossierRepository extends JpaRepository<Dossier, Long> {

    Boolean existsByIdDossier(Long id);


    Dossier findDossierByIdDossier(Long idDossier);

    Dossier findDossierByPatient(Patient patient);


    @Transactional
    @Modifying
    @Query("delete from Dossier d where d.idDossier=:idDossier")
    void deleteDossier(@Param("idDossier") Long idDossier);
}
