package br.com.ratel.apg.application.web.presenter;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import br.com.ratel.apg.application.presenter.PrintPasswordPresenter;
import br.com.ratel.apg.application.web.presenter.viewmodel.PrintPasswordScreenViewModel;
import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;

@Component
class PrintPasswordScreenPresenter implements PrintPasswordPresenter<PrintPasswordScreenViewModel> {
	
	@Override
	public PrintPasswordScreenViewModel toViewModel(ServiceType[] serviceTypes,
		PasswordType[] passwordTypes) {
		PrintPasswordScreenViewModel viewModel = new PrintPasswordScreenViewModel();

		Arrays.stream(serviceTypes).forEach(serviceType -> {
			String buttonDescription = serviceType.getDescription().toUpperCase();
			String inputValue = serviceType.toString();

			PrintPasswordScreenViewModel.Button button
				= new PrintPasswordScreenViewModel.Button(buttonDescription, inputValue);

			viewModel.addServiceTypeButton(button);
		});

		Arrays.stream(passwordTypes).forEach(passwordType -> {
			String buttonDescription = passwordType.getDescription().toUpperCase();
			String inputValue = passwordType.toString();

			PrintPasswordScreenViewModel.Button button
				= new PrintPasswordScreenViewModel.Button(buttonDescription, inputValue);

			viewModel.addPasswordTypeButton(button);
		});

		return viewModel;
	}
}
