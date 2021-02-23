package br.com.ratel.apg.domain.printer.exception;

public class PrintOutException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PrintOutException(String message, Throwable cause) {
		super(message, cause);
	}
}
