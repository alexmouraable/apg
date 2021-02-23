package br.com.ratel.apg.domain.entry.password.response;

import java.time.LocalDate;

import br.com.ratel.apg.domain.constant.PasswordStatus;
import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.type.PasswordNumber;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneratePasswordResponse {
	private Long id;
	private PasswordNumber passwordNumber;
	private PasswordType passwordType;
	private PasswordStatus passwordStatus;
	private LocalDate generationDate;
}
