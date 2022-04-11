package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RepasDto {

    private Long idRepas;

    private String designation;

    public RepasDto(String designation) {
        this.designation = designation;
    }
}
