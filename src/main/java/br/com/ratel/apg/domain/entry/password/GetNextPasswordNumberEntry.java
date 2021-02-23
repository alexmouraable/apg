package br.com.ratel.apg.domain.entry.password;

import br.com.ratel.apg.domain.entry.password.request.GetNextPasswordNumberRequest;
import br.com.ratel.apg.domain.type.PasswordNumber;

public interface GetNextPasswordNumberEntry {
	public PasswordNumber execute(GetNextPasswordNumberRequest request);
}
