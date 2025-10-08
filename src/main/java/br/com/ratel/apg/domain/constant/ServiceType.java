package br.com.ratel.apg.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ServiceType {
    APENAS_MEDICO("Apenas Médico", "MED", "Por favor, dirija-se à RECEPÇÃO 2 no 1º ANDAR."),
    MEDICO_E_EXAMES("Médico e Exame(s)", "MEX", "Por favor, aguarde na RECEPÇÃO 1, no TÉRREO.");

    private String description;
    private String acronym;
    private String receptionMessage;
}
