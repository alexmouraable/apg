package br.com.ratel.apg.infrastructure.validator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.validator.ValidationErrorException;
import br.com.ratel.apg.domain.validator.Validator;

@ExtendWith(SpringExtension.class)
public class ValidatorTests {
	@TestConfiguration
	static class ValidatorTestsConfiguration {
		@Bean("objectValidator")
		public <T> Validator<T> validator() {
			return new ObjectValidator<T>();
		}
	}

	@MockBean
	private javax.validation.Validator validator;

	@Autowired
	private Validator<ExistsPasswordRequest> objectValidator;

	@Test
	public void throwValidationErrorExceptionIfDataIsInvalid() {
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();

		Set<ConstraintViolation<ExistsPasswordRequest>> constraintViolations = Validation.buildDefaultValidatorFactory()
				.getValidator().validate(existsPasswordRequest);

		when(this.validator.validate(existsPasswordRequest)).thenReturn(constraintViolations);

		ValidationErrorException validationErrorException = assertThrows(ValidationErrorException.class,
				() -> this.objectValidator.validate(existsPasswordRequest));

		int expectedNumberOfValidationErrors = 1;
		assertEquals(expectedNumberOfValidationErrors,
				validationErrorException.getResultValidation().numberOfValidationErrors());

		String expectedValidationErrorKey = "passwordType";
		assertTrue(validationErrorException.getResultValidation().containsValidationError(expectedValidationErrorKey));
	}

	@Test
	public void doNotThrowValidationErrorExceptionIfValidData() {
		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(PasswordType.PREFERENCIAL);

		Set<ConstraintViolation<ExistsPasswordRequest>> constraintViolations = Validation.buildDefaultValidatorFactory()
				.getValidator().validate(existsPasswordRequest);

		when(this.validator.validate(existsPasswordRequest)).thenReturn(constraintViolations);

		assertDoesNotThrow(() -> this.objectValidator.validate(existsPasswordRequest));
	}
}