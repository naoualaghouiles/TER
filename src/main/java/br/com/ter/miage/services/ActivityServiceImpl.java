package br.com.ter.miage.services;

import br.com.ter.miage.dto.ActiviteDto;
import br.com.ter.miage.entities.Activity;
import br.com.ter.miage.repositories.ActivityRepository;
import br.com.ter.miage.services.interfaces.ActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {


    final
    ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void ajouterActivities(Activity activity){
        activityRepository.save(activity);
    }

    @Override
    public List<Activity> getAllActivities() {

        return activityRepository.findAll();
    }

    @Override
    public Activity getActivityByDescription(String description) {
        return activityRepository.findActivitiesByDescription(description);
    }

    @Override
    public Activity getActivity(Long idActivity) {

        return activityRepository.findActivitiesByIdActivity(idActivity);
    }

    @Override
    public Activity updateActivity(String oldDescription, String newDescription){

        Activity activity = this.getActivityByDescription(oldDescription);

        if (activity != null) {
            activity.setDescription(newDescription);
            activityRepository.save(activity);
            return activity;
        } else {
            return null;
        }
    }




    @Transactional
    @Override
    public void deleteActivity(Long idActivity) {
        activityRepository.deleteActivities(idActivity);
    }



    @Override
    public Activity modifierActivity(ActiviteDto activiteDto) throws ParseException {
        Activity activity = activityRepository.getById(activiteDto.getIdActivity());

        activity.setDescription(activiteDto.getDescription());
        activity.setPrixA(activiteDto.getPrixA());


        return activityRepository.save(activity);

    }


    @Override
    public Activity addActivity(ActiviteDto activiteDto) {

        Activity activity;

        activity =new Activity(
                activiteDto.getPrixA(),
                activiteDto.getDescription()

        );

        return activityRepository.save(activity);

    }
}
