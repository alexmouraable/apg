package br.com.ratel.apg.domain.usecase.password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.ratel.apg.domain.entry.password.GeneratePasswordEntry;
import br.com.ratel.apg.domain.entry.password.PrintPasswordEntry;
import br.com.ratel.apg.domain.entry.password.request.GeneratePasswordRequest;
import br.com.ratel.apg.domain.entry.password.request.PrintPasswordRequest;
import br.com.ratel.apg.domain.entry.password.response.GeneratePasswordResponse;
import br.com.ratel.apg.domain.printer.Printer;
import br.com.ratel.apg.domain.type.Report;
import br.com.ratel.apg.domain.validator.Validator;

@Service
public class PrintPasswordUseCase implements PrintPasswordEntry {
	@Autowired
	private Validator<PrintPasswordRequest> validator;

	@Autowired
	private GeneratePasswordEntry generatePasswordEntry;

	@Autowired
	private Printer printer;

	@Transactional
	@Override
	public void execute(PrintPasswordRequest request) {
		this.validator.validate(request);
		
		GeneratePasswordResponse generatePasswordResponse = this.generatePasswordEntry
				.execute(new GeneratePasswordRequest(request.getPasswordType()));
		
		Report reportPassword = new Report("Password");
		reportPassword.addParameter("CompanyName", "Clismetra");
		reportPassword.addParameter("PasswordNumber", generatePasswordResponse.getNumber());
		reportPassword.addParameter("PasswordType", generatePasswordResponse.getPasswordType().toString());
		reportPassword.addParameter("GenerationDate", generatePasswordResponse.getGenerationDate().toString());
		
		this.printer.printOut(reportPassword);
	}
}
