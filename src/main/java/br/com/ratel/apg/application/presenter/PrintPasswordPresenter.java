package br.com.ratel.apg.application.presenter;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;

public interface PrintPasswordPresenter<T> {
	public T toViewModel(ServiceType[] serviceTypes, PasswordType[] passwordTypes);
}
