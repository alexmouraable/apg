package br.com.ratel.apg.domain.entry.request;

import br.com.ratel.apg.domain.type.PasswordType;

public class ExistsPasswordRequest {
	private PasswordType passwordType;

	public PasswordType getPasswordType() {
		return passwordType;
	}

	public void setPasswordType(PasswordType passwordType) {
		this.passwordType = passwordType;
	}
}
