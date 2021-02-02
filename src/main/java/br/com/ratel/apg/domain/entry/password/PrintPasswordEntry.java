package br.com.ratel.apg.domain.entry.password;

import br.com.ratel.apg.domain.entry.password.request.PrintPasswordRequest;

public interface PrintPasswordEntry {
	public void execute(PrintPasswordRequest request);
}
