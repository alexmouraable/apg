package br.com.ratel.apg.domain.usecase;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.GetGreaterPasswordNumberData;
import br.com.ratel.apg.domain.entry.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.entry.request.GetNextPasswordNumberRequest;

@Service
public class GetNextPasswordNumberUseCase implements GetNextPasswordNumberEntry {
	// @Autowired
	// private Validator validator';

	@Autowired
	private ExistsPasswordEntry existsPasswordEntry;

	@Autowired
	private GetGreaterPasswordNumberData getGreaterPasswordNumberData;

	@Override
	public Integer execute(GetNextPasswordNumberRequest getNextPasswordNumberRequest) {
		// this.validator.validate(getNextPasswordNumberRequest);

		ExistsPasswordRequest existsPasswordRequest = new ExistsPasswordRequest();
		existsPasswordRequest.setPasswordType(getNextPasswordNumberRequest.getPasswordType());

		if (this.existsPasswordEntry.execute(existsPasswordRequest)) {
			Integer nextPasswordNumber = this.getGreaterPasswordNumberData
					.execute(getNextPasswordNumberRequest.getPasswordType(), LocalDate.now()) + 1;
			return nextPasswordNumber;
		}

		return getNextPasswordNumberRequest.getPasswordType().getInitialPasswordNumber();
	}
}
