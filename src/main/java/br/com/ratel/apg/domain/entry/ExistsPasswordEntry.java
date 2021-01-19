package br.com.ratel.apg.domain.entry;

import br.com.ratel.apg.domain.entry.request.ExistsPasswordRequest;

public interface ExistsPasswordEntry {
	public boolean execute(ExistsPasswordRequest request);
}
