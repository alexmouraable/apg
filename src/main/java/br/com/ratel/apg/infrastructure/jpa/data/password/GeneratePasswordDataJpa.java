package br.com.ratel.apg.infrastructure.jpa.data.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.data.password.GeneratePasswordData;
import br.com.ratel.apg.domain.mapper.Mapper;
import br.com.ratel.apg.domain.model.Password;
import br.com.ratel.apg.domain.type.PasswordNumber;
import br.com.ratel.apg.infrastructure.jpa.entity.PasswordEntity;
import br.com.ratel.apg.infrastructure.jpa.repository.PasswordRepository;

@Component
class GeneratePasswordDataJpa implements GeneratePasswordData {
	@Autowired
	private PasswordRepository passwordRepository;

	@Autowired
	private Mapper<Password, PasswordEntity> entityFor;

	@Autowired
	private Mapper<PasswordEntity, Password> modelFor;

	@Override
	public Password execute(Password password) {
		PasswordEntity passwordToGenerate = this.entityFor.map(password, PasswordEntity.class);
		passwordToGenerate.setNumber(password.getPasswordNumber().getNumber());
		
		PasswordEntity generatedPassword = this.passwordRepository.save(passwordToGenerate);
		
		Password mappedGeneratedPassword = this.modelFor.map(generatedPassword, Password.class);
		mappedGeneratedPassword.setPasswordNumber(new PasswordNumber(generatedPassword.getNumber()));
		
		return mappedGeneratedPassword;
	}
}
