package br.com.ratel.apg.application.web.presenter;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.ratel.apg.application.presenter.PrintPasswordPresenter;
import br.com.ratel.apg.application.web.presenter.viewmodel.PrintPasswordScreenViewModel;
import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;

@Component
class PrintPasswordScreenPresenter implements PrintPasswordPresenter<PrintPasswordScreenViewModel> {
	private List<String> serviceTypeButtonTypes = Arrays.asList("primary", "success");
	private List<String> passwordTypeButtonTypes = Arrays.asList("warning", "danger");

	@Override
	public PrintPasswordScreenViewModel toViewModel(ServiceType[] serviceTypes,
		PasswordType[] passwordTypes) {
		PrintPasswordScreenViewModel viewModel = new PrintPasswordScreenViewModel();

		for (int i = 0; i < serviceTypes.length; i++) {
			ServiceType serviceType = serviceTypes[i];
			String buttonDescription = serviceType.getDescription().toUpperCase();
			String inputValue = serviceType.toString();
			String buttonType = serviceTypeButtonTypes.get(i);
	
			PrintPasswordScreenViewModel.Button button
				= new PrintPasswordScreenViewModel.Button(buttonDescription, inputValue, buttonType);
	
			viewModel.addServiceTypeButton(button);
		}

		for (int i = 0; i < passwordTypes.length; i++) {
			PasswordType passwordType = passwordTypes[i];
			String buttonDescription = passwordType.getDescription().toUpperCase();
			String inputValue = passwordType.toString();
			String buttonType = passwordTypeButtonTypes.get(i);
	
			PrintPasswordScreenViewModel.Button button
				= new PrintPasswordScreenViewModel.Button(buttonDescription, inputValue, buttonType);
	
			viewModel.addPasswordTypeButton(button);
		}

		return viewModel;
	}
}
