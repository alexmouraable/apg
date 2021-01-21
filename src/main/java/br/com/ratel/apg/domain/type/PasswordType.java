package br.com.ratel.apg.domain.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PasswordType {
	NORMAL("Normal", 1),
	PREFERENCIAL("Preferencial", 500);
	
	private String description;
	private Integer initialPasswordNumber;
}
