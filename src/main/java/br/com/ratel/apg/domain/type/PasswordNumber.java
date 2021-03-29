package br.com.ratel.apg.domain.type;

import br.com.ratel.apg.domain.type.exception.InvalidPasswordNumberException;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class PasswordNumber {
	private Integer number;

	public PasswordNumber(@NonNull Integer number) {
		if (number < 1) {
			throw new InvalidPasswordNumberException("Password number must be greater than zero");
		}
		
		this.number = number;
	}

	@Override
	public String toString() {
		return String.format("%03d", this.number);
	}
}
