package br.com.ratel.apg.domain.entry.password.response;

import java.time.LocalDateTime;

import br.com.ratel.apg.domain.type.PasswordType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePasswordResponse {
	private Long id;
	private Integer number;
	private PasswordType passwordType;
	private LocalDateTime generationDateAndTime;
}
