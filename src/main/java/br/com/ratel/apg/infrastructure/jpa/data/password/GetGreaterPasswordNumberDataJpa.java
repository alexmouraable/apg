package br.com.ratel.apg.infrastructure.jpa.data.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.data.password.GetGreaterPasswordNumberData;
import br.com.ratel.apg.domain.data.password.request.GetGreaterPasswordNumberDataRequest;
import br.com.ratel.apg.infrastructure.jpa.repository.PasswordRepository;

@Component
class GetGreaterPasswordNumberDataJpa implements GetGreaterPasswordNumberData {
	@Autowired
	private PasswordRepository passwordRepository;

	@Override
	public Integer execute(GetGreaterPasswordNumberDataRequest request) {
		return this.passwordRepository.findMaxPasswordNumberByServiceTypeAndPasswordTypeAndGenerationDate(request.getServiceType(),
			request.getPasswordType(), request.getStartOfDay(), request.getEndOfDay());
	}
}
