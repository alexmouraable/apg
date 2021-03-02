package br.com.ratel.apg.domain.usecase.password;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ratel.apg.domain.constant.PasswordStatus;
import br.com.ratel.apg.domain.data.password.GeneratePasswordData;
import br.com.ratel.apg.domain.entry.password.GeneratePasswordEntry;
import br.com.ratel.apg.domain.entry.password.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.password.request.GeneratePasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.entry.password.response.GeneratePasswordResponse;
import br.com.ratel.apg.domain.mapper.Mapper;
import br.com.ratel.apg.domain.model.Password;
import br.com.ratel.apg.domain.type.PasswordNumber;
import br.com.ratel.apg.domain.validator.Validator;

@Service
class GeneratePasswordUseCase implements GeneratePasswordEntry {
	@Autowired
	private Validator<GeneratePasswordRequest> validator;

	@Autowired
	private GetNextPasswordNumberEntry getNextPasswordNumberEntry;

	@Autowired
	private GeneratePasswordData generatePasswordData;

	@Autowired
	private Mapper<Password, GeneratePasswordResponse> mapper;

	@Transactional
	@Override
	public GeneratePasswordResponse execute(GeneratePasswordRequest generatePasswordRequest) {
		this.validator.validate(generatePasswordRequest);

		GetNextPasswordNumberRequest getNextPasswordNumberRequest = new GetNextPasswordNumberRequest(
				generatePasswordRequest.getPasswordType());

		PasswordNumber nextPasswordNumber = this.getNextPasswordNumberEntry.execute(getNextPasswordNumberRequest);

		Password passwordToGenerate = new Password(null, nextPasswordNumber, generatePasswordRequest.getPasswordType(),
				PasswordStatus.AGUARDANDO, LocalDate.now(ZoneId.of("America/Maceio")));

		Password generatedPassword = this.generatePasswordData.execute(passwordToGenerate);

		return this.mapper.map(generatedPassword, GeneratePasswordResponse.class);
	}
}
