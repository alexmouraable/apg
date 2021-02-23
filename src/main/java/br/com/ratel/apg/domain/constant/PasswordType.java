package br.com.ratel.apg.domain.constant;

import br.com.ratel.apg.domain.type.PasswordNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PasswordType {
	CONVENCIONAL("Convencional", "C", new PasswordNumber(1)),
	PREFERENCIAL("Preferencial", "P", new PasswordNumber(500));
	
	private String description;
	private String acronym;
	private PasswordNumber initialPasswordNumber;
}
