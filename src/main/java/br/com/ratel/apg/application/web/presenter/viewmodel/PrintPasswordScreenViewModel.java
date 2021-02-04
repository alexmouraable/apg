package br.com.ratel.apg.application.web.presenter.viewmodel;

import lombok.Getter;

@Getter
public class PrintPasswordScreenViewModel {
	private String buttonDescription;
	private String classOfButtonBackgroundColor;
	private String inputValue;

	public PrintPasswordScreenViewModel(String buttonDescription, String inputValue) {
		this.buttonDescription = buttonDescription;
		this.classOfButtonBackgroundColor = "Convencional".equals(buttonDescription) ? "btn-success" : "btn-danger";
		this.inputValue = inputValue;
	} 
}
