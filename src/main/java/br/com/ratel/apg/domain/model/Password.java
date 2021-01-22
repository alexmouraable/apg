package br.com.ratel.apg.domain.model;

import java.time.LocalDateTime;

import br.com.ratel.apg.domain.type.PasswordType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Password {
	private Long id;
	private Integer number;
	private PasswordType passwordType;
	private LocalDateTime generationDateAndTime;
}
