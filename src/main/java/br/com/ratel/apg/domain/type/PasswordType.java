package br.com.ratel.apg.domain.type;

public enum PasswordType {
	
	NORMAL("Normal", 1),
	PREFERENCIAL("Preferencial", 500);
	
	private String description;
	private Integer initialPasswordNumber;
	
	PasswordType(String description, Integer initialPasswordNumber) {
		this.description = description;
		this.initialPasswordNumber = initialPasswordNumber;
	}

	public String getDescription() {
		return description;
	}

	public Integer getInitialPasswordNumber() {
		return initialPasswordNumber;
	}
	
}
