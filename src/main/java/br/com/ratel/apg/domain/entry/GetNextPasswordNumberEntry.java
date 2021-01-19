package br.com.ratel.apg.domain.entry;

import br.com.ratel.apg.domain.entry.request.GetNextPasswordNumberRequest;

public interface GetNextPasswordNumberEntry {
	public Integer execute(GetNextPasswordNumberRequest request);
}
