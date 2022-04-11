package br.com.ter.miage.services.interfaces;

import br.com.ter.miage.dto.ActiviteDto;
import br.com.ter.miage.entities.Activity;

import java.text.ParseException;
import java.util.List;

public interface ActivityService {
    void ajouterActivities(Activity activity);

    List<Activity> getAllActivities();

    Activity getActivityByDescription(String description);

    Activity updateActivity(String oldDescription, String newDescription);

    void deleteActivity(Long idActivity);
    Activity getActivity(Long idActivity);
    Activity modifierActivity(ActiviteDto activiteDto) throws ParseException;

    Activity addActivity(ActiviteDto activiteDto);
}
