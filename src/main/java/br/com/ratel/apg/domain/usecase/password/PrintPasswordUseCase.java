package br.com.ratel.apg.domain.usecase.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ratel.apg.domain.entry.password.GeneratePasswordEntry;
import br.com.ratel.apg.domain.entry.password.PrintPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.GeneratePasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.PrintPasswordRequest;
import br.com.ratel.apg.domain.entry.password.response.GeneratePasswordResponse;
import br.com.ratel.apg.domain.validator.Validator;

@Service
public class PrintPasswordUseCase implements PrintPasswordEntry {
	@Autowired
	private Validator<PrintPasswordRequest> validator;

	@Autowired
	private GeneratePasswordEntry generatePasswordEntry;

	@Override
	public void execute(PrintPasswordRequest request) {
		this.validator.validate(request);
		
		GeneratePasswordResponse generatePasswordResponse = this.generatePasswordEntry
				.execute(new GeneratePasswordRequest(request.getPasswordType()));
		
		System.out.println("--- Dbug ---");
		// TODO: Imprimir Relatório de Senha
	}
}
