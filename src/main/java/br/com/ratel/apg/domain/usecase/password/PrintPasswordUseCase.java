package br.com.ratel.apg.domain.usecase.password;

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
import br.com.ratel.apg.domain.utils.TimeUtils;
import br.com.ratel.apg.domain.validator.Validator;

@Service
class PrintPasswordUseCase implements PrintPasswordEntry {
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
			.execute(new GeneratePasswordRequest(request.getServiceType(), request.getPasswordType()));

		String passwordAcronym = generatePasswordResponse.getServiceType().getAcronym()
			+ generatePasswordResponse.getPasswordType().getAcronym();

		Report reportPassword = new Report("Password");
		reportPassword.addParameter("CompanyName", this.companyName);
		reportPassword.addParameter("PasswordAcronym", passwordAcronym);
		reportPassword.addParameter("PasswordNumber", generatePasswordResponse.getPasswordNumber().toString());
		reportPassword.addParameter("ServiceType", generatePasswordResponse.getServiceType().getDescription());
		reportPassword.addParameter("PasswordType", generatePasswordResponse.getPasswordType().getDescription());
		reportPassword.addParameter("ReceptionMessage", generatePasswordResponse.getServiceType().getReceptionMessage());
		reportPassword.addParameter("GenerationDate", TimeUtils.formattedDate(generatePasswordResponse.getGenerationDateTime()));

		this.printer.printOut(reportPassword);
	}
}
