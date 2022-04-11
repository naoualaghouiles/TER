package br.com.ter.miage.services;

import br.com.ter.miage.entities.*;
import br.com.ter.miage.repositories.FactureRepository;
import br.com.ter.miage.services.interfaces.FactureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
public class FactureServiceImpl implements FactureService {

    final
    FactureRepository factureRepository;

    public FactureServiceImpl(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public Facture ajouterFacture(Facture facture){
        return factureRepository.save(facture);
    }

    @Override
    public Facture getById(Long idFacture) {
        return factureRepository.getById(idFacture);
    }

    @Override
    public List<Facture> getAllFactures(){
      return   factureRepository.findAll();
    }


    @Override
    public List<Facture> getFactureByEtat(String etat){
        return factureRepository.findFactureByEtat(etat);
    }

    @Override
    public List<Facture> getFactureByDateF(Date dateF){
        return factureRepository.findAllByDateF(dateF);
    }




    @Transactional
    @Override
    public void deleteFacture(Long idFacture) {
        factureRepository.deleteFacture(idFacture);
    }


    @Override
    public void updatePrixFactures(Patient patient) {
        Set<Facture> factureList = patient.getFactures();

        for (Facture facture :
                factureList) {
            if(facture.getEtat().equals("Provisoire")) {
                double prixActivities = 0;
                for (LigneActivity ligneActivity :
                        facture.getLigneActivitySet()) {
                    prixActivities += ligneActivity.getActivity().getPrixA();
                }

                double prixPrestations = 0;
                for (LignePrestation lignePrestation :
                        facture.getLignePrestationSet()) {
                    prixPrestations += lignePrestation.getPrestation().getPrix();
                }

                Date dateEntree = patient.getDateEntree();


                Calendar cal = Calendar.getInstance();
                cal.setTime(dateEntree);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);

                Calendar calToday = Calendar.getInstance();
                calToday.setTime(new Date());

                double prixSejour = 0;

                if ((calToday.get(Calendar.MONTH) == month) && (calToday.get(Calendar.YEAR) == year)) {
                    int daysBetween = daysBetween(cal.getTime(), calToday.getTime());
                    prixSejour = daysBetween * patient.getGir().getPrix();
                } else {
                    Calendar c = Calendar.getInstance();
                    c.set(Calendar.DAY_OF_MONTH, 0);
                    int daysBetween = daysBetween(c.getTime(), calToday.getTime());
                    prixSejour = daysBetween * patient.getGir().getPrix();
                }

                double prixTotal = prixSejour + prixActivities + prixPrestations;
                prixTotal = round(prixTotal, 2);

                facture.setPrixTotal(prixTotal);

                this.ajouterFacture(facture);
            }
        }


    }

    private int daysBetween(Date d1, Date d2){
        return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    private double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

//    @Override
//    public int getNombreDeJourSejour(Patient patient) {
//
//        Date dateEntree = patient.getDateEntree();
//
//
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(dateEntree);
//        int month = cal.get(Calendar.MONTH);
//        int year = cal.get(Calendar.YEAR);
//
//        Calendar calToday = Calendar.getInstance();
//        calToday.setTime(new Date());
//        int daysBetween = 0;
//
//        if ((calToday.get(Calendar.MONTH) == month) && (calToday.get(Calendar.YEAR) == year)) {
//            daysBetween = daysBetween(cal.getTime(),calToday.getTime());
//        } else {
//            Calendar c = Calendar.getInstance();
//            c.set(Calendar.DAY_OF_MONTH, 0);
//            daysBetween = daysBetween(c.getTime(),calToday.getTime());
//        }
//
//        return daysBetween;
//    }

    @Override
    public int getJourSejour(List<Activity> activityList, List<Prestation> prestationList, Facture facture) {
        double prixActivities = 0;
        double prixPrestations = 0;

        for (Activity activity :
                activityList) {
            prixActivities += activity.getPrixA();
        }

        for (Prestation prestation :
                prestationList) {
            prixPrestations += prestation.getPrix();
        }

        double prixSejour = facture.getPrixTotal() - (prixActivities + prixPrestations);

        int joursSejour = (int) (prixSejour / facture.getPatient().getGir().getPrix());

        return joursSejour;
    }

}
