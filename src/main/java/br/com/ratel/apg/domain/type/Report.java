package br.com.ratel.apg.domain.type;

import java.util.HashMap;
import java.util.Map;

public class Report {
	private String name;
	private Map<String, Object> parameters;
	
	public Report(String name) {
		this.name = name;
	}

	public void addParameter(String key, Object value) {
		this.parameters.put(key, value);
	}
	
	public Map<String, Object> getParameters() {
		Map<String, Object> clonedParameters = new HashMap<String, Object>();
		clonedParameters.putAll(this.parameters);
		return clonedParameters;
	}

	public String getName() {
		return this.name;
	}
}
