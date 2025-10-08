package br.com.ratel.apg.infrastructure.jpa.data.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.data.password.ExistsPasswordData;
import br.com.ratel.apg.domain.data.password.request.ExistsPasswordDataRequest;
import br.com.ratel.apg.infrastructure.jpa.repository.PasswordRepository;

@Component
class ExistsPasswordDataJpa implements ExistsPasswordData {
	@Autowired
	private PasswordRepository passwordRepository;

	@Override
	public boolean execute(ExistsPasswordDataRequest request) {
		return this.passwordRepository.existsByServiceTypeAndPasswordTypeAndGenerationDate(request.getServiceType(),
			request.getPasswordType(), request.getStartOfDay(), request.getEndOfDay());
	}
}
