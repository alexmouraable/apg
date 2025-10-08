package br.com.ratel.apg.domain.usecase.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.GetGreaterPasswordNumberData;
import br.com.ratel.apg.domain.data.password.request.GetGreaterPasswordNumberDataRequest;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.GetNextPasswordNumberEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.type.PasswordNumber;
import br.com.ratel.apg.domain.utils.TimeUtils;
import br.com.ratel.apg.domain.validator.Validator;

@Service
class GetNextPasswordNumberUseCase implements GetNextPasswordNumberEntry {
	private static final PasswordNumber INITIAL_PASSWORD_NUMBER
		= new PasswordNumber(1);

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
			getNextPasswordNumberRequest.getServiceType(), getNextPasswordNumberRequest.getPasswordType());

		if (this.existsPasswordEntry.execute(existsPasswordRequest)) {
			GetGreaterPasswordNumberDataRequest getGreaterPasswordNumberDataRequest = new GetGreaterPasswordNumberDataRequest(getNextPasswordNumberRequest.getServiceType(),
				getNextPasswordNumberRequest.getPasswordType(), TimeUtils.startOfDay(), TimeUtils.endOfDay()); 

			Integer nextPasswordNumber = this.getGreaterPasswordNumberData.execute(getGreaterPasswordNumberDataRequest) + 1;

			return new PasswordNumber(nextPasswordNumber);
		}

		return INITIAL_PASSWORD_NUMBER;
	}
}
