package br.com.ratel.apg.domain.entry.password.request;

import javax.validation.constraints.NotNull;

import br.com.ratel.apg.domain.type.PasswordType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExistsPasswordRequest {
	
	@NotNull(message = "PasswordType é obrigatório")
	private PasswordType passwordType;
	
}
