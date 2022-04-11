package br.com.ter.miage;


import br.com.ter.miage.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DbOperationRunner implements CommandLineRunner {

    @Autowired
    PatientService patientService;

    @Autowired
    AdminService adminService;

    @Autowired
    RepasService repasService;

    @Autowired
    DossierService dossierService;

    @Autowired
    MaladieService maladieService;


    @Autowired
    MedicamentsService medicamentsService;

    @Autowired
    ActivityService activityService;

    @Autowired
    PrestationService prestationService;

    @Autowired
    SoinsService soinsService;

    @Autowired
    DirecteurService directeurService;

    @Autowired
    FactureService factureService ;

    @Override
    public void run(String... args) throws Exception {
//        UserDto userDto = new UserDto("Naoual",
//                "Aghouiles",
//                "naoual@gmail.com",
//                "123");
//
//        userService.saveUser(userDto);

//        PatientDto patientDto = new PatientDto(
//                "NomPa",
//                "PrenomPa",
//                "patient@gmail.com",
//                "Paris"
//        );
////
//        patientService.saveUser(patientDto);

//        List<Patient> patientList = patientService.getAllPatients();
//
//        for (Patient patient:
//             patientList) {
//            System.out.println(patient.getPrenom() + " " + patient.getNom());
//        }

//        Repas repas = new Repas("Viande");
//
//        repasService.ajouterRepas(repas);

//        List<Repas> repasList = repasService.getAllRepas();
//
//        for (Repas repas :
//                repasList) {
//            System.out.println(repas.getDesignation());
//        }

//        Repas repas = repasService.getRepasByDesignation("Boeuf");
//
//        System.out.println(repas.getDesignation());

//        Repas repas = repasService.updateRepas("Boeuf", "Viande");


//        System.out.println(repas.getDesignation());

//        repasService.deleteRepas("Viande");


//        Repas repas = new Repas("Veg");
//
//        repasService.ajouterRepas(repas);

//        Repas repasViande = repasService.getRepasByDesignation("Viande");
//        Repas repasVeg = repasService.getRepasByDesignation("Veg");
//
//        Dossier dossier = dossierService.getDossierById(Long.valueOf("1"));
//
//        dossier.getRepasSet().add(repasViande);
//        dossier.getRepasSet().add(repasVeg);
//
//        dossierService.ajouterDossier(dossier);

//        Dossier dossier = new Dossier();
//
//        dossier.getRepasSet().add(repas);
//
//        dossierService.ajouterDossier(dossier);

//        Maladie maladie = new Maladie("Leqrih oqerroy");
//
//        maladieService.saveMaladie(maladie);

//        Dossier dossier = new Dossier();
//
//        Maladie maladie = maladieService.getMaladieByDescription("Leqrih oqerroy");
//
//        dossier.setMaladie(maladie);
//
//        dossierService.ajouterDossier(dossier);

       // Maladie maladie = maladieService.getMaladieByDescription("Leqrih oqerroy");

        //Set<Dossier> dossierSet = maladie.getDossiers();

        //for (Dossier dossier:
        //     dossierSet) {
        //    System.out.println(dossier.getIdDossier());
        //}


        // insertion
      //  Medicaments medicaments= new Medicaments("doliprane");
      //  medicamentsService.ajouterMedicaments(medicaments);

      //  Activities activities= new Activities("natation");
       // activitiesService.ajouterActivities(activities);

     // Prestations prestations=new Prestations("chambre double", 20);
     // prestationsService.ajouterPrestations(prestations);

//        Directeur directeur=new Directeur("Benz","Macyl","benz@gmail.com");
//        directeurService.ajouterDirecteur(directeur);
//
//        Directeur directeur2=new Directeur("Agh","Naw","naw@gmail.com");
//        directeurService.ajouterDirecteur(directeur2);
//
        //Ajout une Date
//        Date date = null;
//
//        date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-03-01");
//
//        Facture facture=new Facture("ref1","desc1","etat1","type1",date);
//        factureService.ajouterFacture(facture);
//
//

        //afficher la liste des medocs

     //   List<Medicaments> medList= medicamentsService.getAllMedicaments();
       // for (Medicaments medicaments:
         //   medList ) {
           // System.out.println(medicaments.getDesignationMed());
//
  //      }

//        List<Facture> factureList=factureService.getAllFactures();
//        for (Facture facture :
//        factureList) {
//            System.out.println(facture.getDateF()+
//                    " "+facture.getDescriptionF()+
//                    " "+facture.getEtat()+
//                    " "+facture.getReference()+
//                    " "+facture.getType()+
//                    " "+facture.getIdFacture());
//        }
       // List<Soins> soinsL=soinsService.getAllSoins();
       // for (Soins soins:
         //   soinsL ) {
           // System.out.println(soins.getCommentaire()+" "+soins.getDesignationS()+" "+soins.getDate());
            //
       // }



      //  List<Prestations> prestationsList=prestationsService.getAllPrestations();
      //  for (Prestations prestations :
        //        prestationsList) {
          //  System.out.println(prestations.getPrix()+" "+prestations.getDesignationP()+
            //        " "+prestations.getIdPrestation());
//
  //      }




      //  List<Activities> activitiesList=activitiesService.getAllActivities();
       // for (Activities activities :
         //       activitiesList ){
           // System.out.println(activities.getDescription()+
             //       " "+activities.getIdActivities()+" "+
               //     activities.getPrixA());
//
  //      }




//recupere les medoc selon la designation
     //   Medicaments medicaments = medicamentsService.getMedicamentsByDesignationMed("doliprane");
//
 //      System.out.println(medicaments.getDesignationMed());

    //    Activities activities=activitiesService.getActivitiesByDescription("sky");
      //  System.out.println(activities.getDescription() +" "+activities.getPrixA()
      //  +" "+activities.getIdActivities());

//        List<Directeur> directeurList=directeurService.getDirecteurByNom("Benz");
//        for (Directeur directeur:
//                directeurList ) {
//            System.out.println(directeur.getPrenom());
//        }

//        List<Facture> factureList=factureService.getFactureByReference("ref1");
//        for (Facture facture :
//                factureList) {
//                System.out.println(facture.getDescriptionF());
//        }


//                List<Facture> factureList=factureService.getFactureByDescriptionF("desc1");
//        for (Facture facture :
//                factureList) {
//                System.out.println(facture.getEtat());
//        }

    //   Prestations prestations=prestationsService.getPrestationsByDesignationP("chambre double");
     //   System.out.println(prestations.getIdPrestation()+
      //          " "+prestations.getDesignationP()+
       //         " "+prestations.getPrix());




        //modifier
     //   Medicaments medicaments=medicamentsService.updateMedicaments("doliprane", "Creme");
//
       // System.out.println(medicaments.getDesignationMed());

  //      Soins soins=soinsService.updateSoins("diabete","Diabéte");
    //    System.out.println(soins.getIdSoin()+
      //          " "+soins.getDesignationS()+
        //        " "+soins.getDate());



      //  medicamentsService.deleteMedicaments("creme");

        //creation many to many
//        Dossier dossier = dossierService.getDossierById(Long.valueOf("1"));

//        Maladie maladie1 = maladieService.getMaladieByDescription("Diabète");
//
//
//        Maladie maladie2 = maladieService.getMaladieByDescription("Tension");
//
//        dossier.getMaladieSet().add(maladie1);
//        dossier.getMaladieSet().add(maladie2);
//
//        dossierService.ajouterDossier(dossier);



    }




}
