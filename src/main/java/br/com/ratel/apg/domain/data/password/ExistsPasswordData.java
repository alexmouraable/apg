package br.com.ratel.apg.domain.data.password;

import java.time.LocalDate;

import br.com.ratel.apg.domain.type.PasswordType;

public interface ExistsPasswordData {
	public boolean execute(PasswordType passwordType, LocalDate date);
}