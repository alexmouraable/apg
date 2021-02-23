package br.com.ratel.apg.domain.model;

import java.time.LocalDate;

import br.com.ratel.apg.domain.constant.PasswordStatus;
import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.type.PasswordNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Password {
	private Long id;
	private PasswordNumber passwordNumber;
	private PasswordType passwordType;
	private PasswordStatus passwordStatus;
	private LocalDate generationDate;
}
