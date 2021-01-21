package br.com.ratel.apg.domain.usecase.password;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.data.password.ExistsPasswordData;
import br.com.ratel.apg.domain.entry.password.ExistsPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;

@Service
public class ExistsPasswordUseCase implements ExistsPasswordEntry {
	@Autowired
	private ExistsPasswordData existsPasswordData;
	
	@Override
	public boolean execute(ExistsPasswordRequest request) {
		// TODO: Validar ExistsPasswordRequest
		return this.existsPasswordData.execute(request.getPasswordType(), LocalDate.now());
	}
}