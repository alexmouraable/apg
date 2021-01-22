package br.com.ratel.apg.domain.validator;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultValidation {
	private Map<String, ValidationError> validationErrors = new LinkedHashMap<String, ValidationError>();

	public void addValidationError(ValidationError validationError) {
		this.validationErrors.put(validationError.getKey(), validationError);
	}
	
	public ValidationError getValidationError(String key) {
		return this.validationErrors.get(key);
	}
	
	public boolean containsValidationError(String key) {
		return this.validationErrors.containsKey(key);
	}
	
	public int numberOfValidationErrors() {
		return this.validationErrors.size();
	}
}
