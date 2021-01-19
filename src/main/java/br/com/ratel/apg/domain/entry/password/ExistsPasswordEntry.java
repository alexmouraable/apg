package br.com.ratel.apg.domain.entry.password;

import br.com.ratel.apg.domain.entry.password.request.ExistsPasswordRequest;

public interface ExistsPasswordEntry {
	public boolean execute(ExistsPasswordRequest request);
}
