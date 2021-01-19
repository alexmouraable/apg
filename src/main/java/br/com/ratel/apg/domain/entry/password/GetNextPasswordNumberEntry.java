package br.com.ratel.apg.domain.entry.password;

import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;

public interface GetNextPasswordNumberEntry {
	public Integer execute(GetNextPasswordNumberRequest request);
}
