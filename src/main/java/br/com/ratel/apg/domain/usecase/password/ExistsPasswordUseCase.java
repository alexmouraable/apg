package br.com.ratel.apg.domain.usecase.password;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.ExistsPasswordData;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;
import br.com.ratel.apg.domain.validator.Validator;

@Service
public class ExistsPasswordUseCase implements ExistsPasswordEntry {
	@Autowired
	private ExistsPasswordData existsPasswordData;
	
	@Autowired
	private Validator<ExistsPasswordRequest> validator;
	
	@Override
	public boolean execute(ExistsPasswordRequest request) {
		this.validator.validate(request);
		return this.existsPasswordData.execute(request.getPasswordType(), LocalDate.now(ZoneId.of("America/Maceio")));
	}
}
