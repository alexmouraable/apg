package br.com.ratel.apg.domain.usecase.password;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.GeneratePasswordData;
import br.com.ratel.apg.domain.entry.password.GeneratePasswordEntry;
import br.com.ratel.apg.domain.entry.password.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.password.request.GeneratePasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.entry.password.response.GeneratePasswordResponse;
import br.com.ratel.apg.domain.model.Password;
import br.com.ratel.apg.domain.validator.Validator;

@Service
public class GeneratePasswordUseCase implements GeneratePasswordEntry {
	@Autowired
	private Validator<GeneratePasswordRequest> validator;

	@Autowired
	private GetNextPasswordNumberEntry getNextPasswordNumberEntry;

	@Autowired
	private GeneratePasswordData generatePasswordData;

	@Override
	public GeneratePasswordResponse execute(GeneratePasswordRequest generatePasswordRequest) {
		this.validator.validate(generatePasswordRequest);

		GetNextPasswordNumberRequest getNextPasswordNumberRequest = new GetNextPasswordNumberRequest(
				generatePasswordRequest.getPasswordType());

		Integer nextPasswordNumber = this.getNextPasswordNumberEntry.execute(getNextPasswordNumberRequest);

		Password passwordToGenerate = new Password(null, nextPasswordNumber, generatePasswordRequest.getPasswordType(),
				LocalDateTime.now());

		Password generatedPassword = this.generatePasswordData.execute(passwordToGenerate);

		return new GeneratePasswordResponse(generatedPassword.getId(), generatedPassword.getNumber(),
				generatedPassword.getPasswordType(), generatedPassword.getGenerationDateAndTime());
	}
}
