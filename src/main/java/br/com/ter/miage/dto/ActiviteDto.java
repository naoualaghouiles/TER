package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActiviteDto {
    private Long idActivity;

    private Double prixA;
    private String description;


    public ActiviteDto(Double prixA, String description) {
        this.prixA = prixA;
        this.description = description;
    }
}
