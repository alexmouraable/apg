package br.com.ratel.apg.domain.entry.password.request;

import br.com.ratel.apg.domain.type.PasswordType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetNextPasswordNumberRequest {
	private PasswordType passwordType;
}
