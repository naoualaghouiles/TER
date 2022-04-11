package br.com.ter.miage.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InfermiereDto {

    private Long idInfermiere;

    private String nomI;

    private String prenomI;

    private String emailI;

    public InfermiereDto(String nomI, String prenomI, String emailI) {
        this.nomI = nomI;
        this.prenomI = prenomI;
        this.emailI = emailI;
    }
}
