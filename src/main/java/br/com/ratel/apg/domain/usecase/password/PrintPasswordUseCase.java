package br.com.ratel.apg.domain.usecase.password;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	@Value("${apg.company.name}")
	private String companyName;

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

		String formattedPasswordNumber = String.format("%03d", generatePasswordResponse.getNumber());
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", new Locale("pt", "BR"));
		
		String formattedGenerationDate = generatePasswordResponse.getGenerationDate().format(dateTimeFormatter);
		
		Report reportPassword = new Report("Password");
		reportPassword.addParameter("CompanyName", this.companyName);
		reportPassword.addParameter("PasswordTypeAcronym", generatePasswordResponse.getPasswordType().getAcronym());
		reportPassword.addParameter("PasswordNumber", formattedPasswordNumber);
		reportPassword.addParameter("PasswordType", generatePasswordResponse.getPasswordType().getDescription());
		reportPassword.addParameter("GenerationDate", formattedGenerationDate);

		this.printer.printOut(reportPassword);
	}
}
