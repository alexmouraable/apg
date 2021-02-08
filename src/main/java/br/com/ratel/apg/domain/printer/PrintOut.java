package br.com.ratel.apg.domain.printer;

import br.com.ratel.apg.domain.type.Report;

public interface PrintOut {
	public void execute(Report report, String printerName);
}
