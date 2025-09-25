package br.com.ratel.apg.application.web.presenter.viewmodel;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class PrintPasswordScreenViewModel {
	private List<Button> serviceTypeButtons;
	private List<Button> passwordTypeButtons;

	public PrintPasswordScreenViewModel() {
		this.serviceTypeButtons = new ArrayList<>();
		this.passwordTypeButtons = new ArrayList<>();
	}

	public void addServiceTypeButton(Button button) {
		this.serviceTypeButtons.add(button);
	}

	public void addPasswordTypeButton(Button button) {
		this.passwordTypeButtons.add(button);
	}

	@AllArgsConstructor
	@Getter
	public static class Button {
		private String description;
		private String inputValue;
		private String type;
	}
}
