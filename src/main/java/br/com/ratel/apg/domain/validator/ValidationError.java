package br.com.ratel.apg.domain.validator;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ValidationError {
	@EqualsAndHashCode.Include
	private String key;
	
	private String attribute;
	
	private String reason;
}