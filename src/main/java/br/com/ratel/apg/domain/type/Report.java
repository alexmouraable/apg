package br.com.ratel.apg.domain.type;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Report {
	@NonNull
	private String description;
	private Map<String, Object> parameters = new HashMap<String, Object>();

	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}

	public Map<String, Object> getParameters() {
		Map<String, Object> clonedParameters = new HashMap<String, Object>();
		clonedParameters.putAll(this.parameters);
		return clonedParameters;
	}

	public InputStream getInputStream() {
		String reportPath = String.format("/reports/%s.jasper", this.description);
		return this.getClass().getResourceAsStream(reportPath);
	}

	@Override
	public String toString() {
		return String.format("%s.jasper", this.description);
	}
}
