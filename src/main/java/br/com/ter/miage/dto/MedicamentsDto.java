package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicamentsDto {
    private Long idMedicaments;

    private String designationMed;

    public MedicamentsDto(String designationMed) {
        this.designationMed = designationMed;
    }
}
