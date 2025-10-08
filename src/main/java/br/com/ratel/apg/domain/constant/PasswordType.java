package br.com.ratel.apg.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PasswordType {
	CONVENCIONAL("Convencional", "C"),
	PREFERENCIAL("Preferencial", "P");
	
	private String description;
	private String acronym;
}
