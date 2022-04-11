package br.com.ter.miage.repositories;

import br.com.ter.miage.entities.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
   Activity findActivitiesByDescription(String description);

   Activity findActivitiesByIdActivity(Long idActivities);

    @Modifying
    @Query("delete from Activity a where a.description=:description")
    void deleteActivities(@Param("description") String description);


    @Transactional
    @Modifying
    @Query("delete from Activity a where a.idActivity=:idActivity")
    void deleteActivities(@Param("idActivity") Long idActivity);
}
