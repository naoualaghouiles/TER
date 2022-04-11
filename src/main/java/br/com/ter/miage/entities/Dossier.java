package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Dossier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDossier;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "dossier_repas",
//            joinColumns = {
//                    @JoinColumn(name = "dossier_id", referencedColumnName = "idDossier",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "repas_id", referencedColumnName = "idRepas",
//                            nullable = false, updatable = false)})
//    private Set<Repas> repasSet = new HashSet<>();


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "dossier_maladie",
//            joinColumns = {
//                    @JoinColumn(name = "dossier_id", referencedColumnName = "idDossier",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "maladie_id", referencedColumnName = "idMaladie",
//                            nullable = false, updatable = false)})
//    private Set<Maladie> maladieSet = new HashSet<>();


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "dossier_activities",
//            joinColumns = {
//                    @JoinColumn(name = "dossier_id", referencedColumnName = "idDossier",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "activities_id", referencedColumnName = "idActivities",
//                            nullable = false, updatable = false)})
//    private Set<Activities> activitiesSet = new HashSet<>();


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "dossier_medicaments",
//            joinColumns = {
//                    @JoinColumn(name = "dossier_id", referencedColumnName = "idDossier",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "medicaments_id", referencedColumnName = "idMedicaments",
//                            nullable = false, updatable = false)})
//    private Set<Medicaments> medicamentsSet = new HashSet<>();


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "dossier_prestations",
//            joinColumns = {
//                    @JoinColumn(name = "dossier_id", referencedColumnName = "idDossier",
//                            nullable = false, updatable = false)},
//            inverseJoinColumns = {
//                    @JoinColumn(name = "prestations_id", referencedColumnName = "idPrestation",
//                            nullable = false, updatable = false)})
//    private Set<Prestations> prestationsSet = new HashSet<>();


//    @OneToMany(mappedBy = "dossier",fetch = FetchType.EAGER)
//    private Set<Soins> soins;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "idPatient")
    private Patient patient;


    public Dossier(Patient patient) {
        this.patient = patient;
    }
}
