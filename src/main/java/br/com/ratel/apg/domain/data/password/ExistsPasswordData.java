package br.com.ratel.apg.domain.data.password;

import br.com.ratel.apg.domain.data.password.request.ExistsPasswordDataRequest;

public interface ExistsPasswordData {
	public boolean execute(ExistsPasswordDataRequest request);
}
