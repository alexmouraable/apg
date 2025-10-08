package br.com.ratel.apg.domain.entry.password.request;

import javax.validation.constraints.NotNull;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GetNextPasswordNumberRequest {
	@NotNull(message = "Tipo de serviço é obrigatório")
	private ServiceType serviceType;

	@NotNull(message = "Tipo de senha é obrigatório")
	private PasswordType passwordType;
}
