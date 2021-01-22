package br.com.ratel.apg.domain.entry.password;

import br.com.ratel.apg.domain.entry.password.request.GeneratePasswordRequest;
import br.com.ratel.apg.domain.entry.password.response.GeneratePasswordResponse;

public interface GeneratePasswordEntry {
	public GeneratePasswordResponse execute(GeneratePasswordRequest request);
}
