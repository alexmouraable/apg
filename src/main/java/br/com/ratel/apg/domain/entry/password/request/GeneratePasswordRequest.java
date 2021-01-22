package br.com.ratel.apg.domain.entry.password.request;

import javax.validation.constraints.NotNull;

import br.com.ratel.apg.domain.type.PasswordType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePasswordRequest {
	@NotNull(message = "Tipo de senha é obrigatório")
	private PasswordType passwordType;
}