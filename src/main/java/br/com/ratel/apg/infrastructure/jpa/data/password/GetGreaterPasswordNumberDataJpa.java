package br.com.ratel.apg.infrastructure.jpa.data.password;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.data.password.GetGreaterPasswordNumberData;
import br.com.ratel.apg.infrastructure.jpa.repository.PasswordRepository;

@Component
class GetGreaterPasswordNumberDataJpa implements GetGreaterPasswordNumberData {
	@Autowired
	private PasswordRepository passwordRepository;

	@Override
	public Integer execute(PasswordType passwordType, LocalDate generationDate) {
		return this.passwordRepository.findMaxPasswordNumberByPasswordTypeAndGenerationDate(passwordType, generationDate);
	}
}
