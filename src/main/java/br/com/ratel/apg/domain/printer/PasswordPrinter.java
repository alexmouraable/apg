package br.com.ratel.apg.domain.printer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.type.Report;

@Component
class PasswordPrinter implements Printer {
	@Value("${apg.printers.password-printer.name}")
	private String printerName;
	
	@Autowired
	private PrintOut printOut;
	
	@Override
	public void printOut(Report report) {
		this.printOut.execute(report, this.printerName);
	}
}
