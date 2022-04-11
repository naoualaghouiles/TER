package br.com.ter.miage.repositories;


import br.com.ter.miage.entities.Medicaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentsRepository extends JpaRepository<Medicaments, Long> {

    List<Medicaments> findMedicamentsByDesignationMed(String designationMed);

    Medicaments findMedicamentsByIdMedicaments(Long idMedicaments);



    @Modifying
    @Query("delete from Medicaments m where m.idMedicaments=:idMedicaments")
    void deleteMedicaments(@Param("idMedicaments") Long idMedicaments);

}
