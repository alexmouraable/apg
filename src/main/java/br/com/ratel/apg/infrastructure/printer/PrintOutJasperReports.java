package br.com.ratel.apg.infrastructure.printer;

import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.PrinterName;

import org.springframework.stereotype.Component;

import br.com.ratel.apg.domain.printer.PrintOut;
import br.com.ratel.apg.domain.printer.exception.PrintOutException;
import br.com.ratel.apg.domain.type.Report;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;

@Component
class PrintOutJasperReports implements PrintOut {
	@Override
	public void execute(Report report, String printerName) {
		try {
			this.tryToPrint(report, printerName);
		} catch (Exception exception) {
			throw new PrintOutException("The " + "\"" + report.getName() + "\"" + " report could not be printed",
					exception);
		}
	}

	private void tryToPrint(Report report, String printerName) throws Exception {
		PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
		printServiceAttributeSet.add(new PrinterName(printerName, null));
		
		SimplePrintServiceExporterConfiguration simplePrintServiceExporterConfiguration = new SimplePrintServiceExporterConfiguration();
		simplePrintServiceExporterConfiguration.setPrintServiceAttributeSet(printServiceAttributeSet);
		
		JasperPrint jasperPrint = JasperFillManager.fillReport(report.getInputStream(), report.getParameters(), new JREmptyDataSource(1));

		JRPrintServiceExporter jrPrintServiceExporter = new JRPrintServiceExporter();
		jrPrintServiceExporter.setConfiguration(simplePrintServiceExporterConfiguration);
		jrPrintServiceExporter.setExporterInput(new SimpleExporterInput(jasperPrint));

		jrPrintServiceExporter.exportReport();
	}
}
