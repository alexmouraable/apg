package br.com.ratel.apg.domain.type.exception;

public class InvalidPasswordNumberException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidPasswordNumberException(String message) {
		super(message);
	}
}
