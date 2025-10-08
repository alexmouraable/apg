package br.com.ratel.apg.domain.usecase.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.ExistsPasswordData;
import br.com.ratel.apg.domain.data.password.request.ExistsPasswordDataRequest;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.utils.TimeUtils;
import br.com.ratel.apg.domain.validator.Validator;

@Service
class ExistsPasswordUseCase implements ExistsPasswordEntry {
	@Autowired
	private ExistsPasswordData existsPasswordData;
	
	@Autowired
	private Validator<ExistsPasswordRequest> validator;
	
	@Override
	public boolean execute(ExistsPasswordRequest existsPasswordRequest) {
		this.validator.validate(existsPasswordRequest);
		
		ExistsPasswordDataRequest existsPasswordDataRequest = new ExistsPasswordDataRequest(existsPasswordRequest.getServiceType(),
			existsPasswordRequest.getPasswordType(), TimeUtils.startOfDay(), TimeUtils.endOfDay()); 

		return this.existsPasswordData.execute(existsPasswordDataRequest);
	}
}
