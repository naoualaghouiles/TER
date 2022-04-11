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
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepas;

    @Column(unique = true)
    private String designation;

    @Column(nullable = true, length = 256)
    private String photos;


//    @ManyToMany(mappedBy = "repasSet", fetch = FetchType.EAGER)
//    private Set<Dossier> dossiers = new HashSet<>();

    public Repas(String designation) {
        this.designation = designation;
    }

    public Repas(String designation, String photos) {
        this.designation = designation;
        this.photos = photos;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || idRepas == null) return null;

        return "repas-photos/" + idRepas + "/" + photos;
    }
}
