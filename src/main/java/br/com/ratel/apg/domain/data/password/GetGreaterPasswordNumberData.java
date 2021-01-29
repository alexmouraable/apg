package br.com.ratel.apg.domain.data.password;

import java.time.LocalDate;

import br.com.ratel.apg.domain.constant.PasswordType;

public interface GetGreaterPasswordNumberData {
	public Integer execute(PasswordType passwordType, LocalDate date);
}
