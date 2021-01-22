package br.com.ratel.apg.domain.validator;

public interface Validator<T> {
	public void validate(T value);
}
