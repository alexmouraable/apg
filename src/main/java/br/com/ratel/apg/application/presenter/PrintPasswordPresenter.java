package br.com.ratel.apg.application.presenter;

import br.com.ratel.apg.domain.constant.PasswordType;

public interface PrintPasswordPresenter<T> {
	public T toViewModel(PasswordType[] passwordTypes);
}
