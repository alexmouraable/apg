package br.com.ratel.apg.domain.validator;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValidationErrorException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ResultValidation resultValidation;
}
