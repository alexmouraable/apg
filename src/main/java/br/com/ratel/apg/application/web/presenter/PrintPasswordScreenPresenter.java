package br.com.ratel.apg.application.web.presenter;

import org.springframework.stereotype.Component;

import br.com.ratel.apg.application.presenter.PrintPasswordPresenter;
import br.com.ratel.apg.application.web.presenter.viewmodel.PrintPasswordScreenViewModel;
import br.com.ratel.apg.domain.constant.PasswordType;

@Component
public class PrintPasswordScreenPresenter implements PrintPasswordPresenter<PrintPasswordScreenViewModel[]> {
	@Override
	public PrintPasswordScreenViewModel[] toViewModel(PasswordType[] passwordTypes) {
		PrintPasswordScreenViewModel[] viewModel = new PrintPasswordScreenViewModel[2];
		
		for (int i=0; i < passwordTypes.length; i++) {
			PasswordType passwordType = passwordTypes[i];
			viewModel[i] = new PrintPasswordScreenViewModel(passwordType.getDescription(), passwordType.toString());
		}
		
		return viewModel;
	}
}
