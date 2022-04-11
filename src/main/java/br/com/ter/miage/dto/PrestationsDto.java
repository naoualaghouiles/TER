package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PrestationsDto {

    private Long idPrestation;

    private String designationP;
    private double prix;

    public PrestationsDto(String designationP, double prix) {
        this.designationP = designationP;
        this.prix = prix;
    }
}
