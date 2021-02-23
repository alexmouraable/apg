package br.com.ratel.apg.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PasswordType {
	CONVENCIONAL("Convencional", "C", 1),
	PREFERENCIAL("Preferencial", "P", 500);
	
	private String description;
	private String acronym;
	private Integer initialPasswordNumber;
}
