package br.com.ter.miage.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Patient implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPatient;

    private String nom;

    private String prenom;

    private  String sexe;

    private  String adresse;

    @Temporal(TemporalType.DATE)
    private Date dateEntree;

    private String email;

    private String password;

    private String numTel;

    @Temporal(TemporalType.DATE)
    private Date dateNaissance;


    @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "idGir",nullable = false)
    private Gir gir;

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Facture> factures;

//    @OneToOne(fetch = FetchType.EAGER, optional = true)
//    @JoinColumn(name = "idDossier")
@OneToOne(mappedBy = "patient", fetch = FetchType.EAGER)
    private Dossier dossier;

    public Patient(String nom, String prenom, String sexe, String adresse, Date dateEntree, String email, String password, String numTel, Date dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.dateEntree = dateEntree;
        this.email = email;
        this.password = password;
        this.numTel = numTel;
        this.dateNaissance = dateNaissance;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority("ROLE_USER");
        return Collections.singletonList(authority);
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
