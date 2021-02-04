package br.com.ratel.apg.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PasswordType {
	CONVENCIONAL("Convencional", 1),
	PREFERENCIAL("Preferencial", 500);
	
	private String description;
	private Integer initialPasswordNumber;
}
