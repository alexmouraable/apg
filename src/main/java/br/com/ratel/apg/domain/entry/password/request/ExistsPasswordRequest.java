package br.com.ratel.apg.domain.entry.password.request;

import javax.validation.constraints.NotNull;

import br.com.ratel.apg.domain.type.PasswordType;

public class ExistsPasswordRequest {
	@NotNull(message = "PasswordType é obrigatório")
	private PasswordType passwordType;

	public PasswordType getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(PasswordType passwordType) {
		this.passwordType = passwordType;
	}
}
