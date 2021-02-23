package br.com.ratel.apg.domain.usecase.password;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.GetGreaterPasswordNumberData;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.type.PasswordNumber;
import br.com.ratel.apg.domain.validator.Validator;

@Service
public class GetNextPasswordNumberUseCase implements GetNextPasswordNumberEntry {
	@Autowired
	private Validator<GetNextPasswordNumberRequest> validator;

	@Autowired
	private ExistsPasswordEntry existsPasswordEntry;

	@Autowired
	private GetGreaterPasswordNumberData getGreaterPasswordNumberData;

	@Override
	public PasswordNumber execute(GetNextPasswordNumberRequest getNextPasswordNumberRequest) {
		this.validator.validate(getNextPasswordNumberRequest);

		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest(
				getNextPasswordNumberRequest.getPasswordType());

		if (this.existsPasswordEntry.execute(existsPasswordRequest)) {
			Integer nextPasswordNumber = this.getGreaterPasswordNumberData
					.execute(getNextPasswordNumberRequest.getPasswordType(), LocalDate.now()) + 1;

			return new PasswordNumber(nextPasswordNumber);
		}

		return getNextPasswordNumberRequest.getPasswordType().getInitialPasswordNumber();
	}
}
