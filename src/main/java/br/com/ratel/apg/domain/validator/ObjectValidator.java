package br.com.ratel.apg.domain.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectValidator<T> implements Validator<T> {
	@Autowired
	private javax.validation.Validator validator;

	@Override
	public void validate(T value) {
		Set<ConstraintViolation<T>> constraintViolations = this.validator.validate(value);

		if (!constraintViolations.isEmpty()) {
			ResultValidation resultValidation = new ResultValidation();

			constraintViolations.forEach(constraintViolation -> {
				String attribute = constraintViolation.getPropertyPath().toString();

				resultValidation.addValidationError(
						new ValidationError(attribute, attribute, constraintViolation.getMessage()));
			});

			throw new ValidationErrorException(resultValidation);
		}
	}
}
