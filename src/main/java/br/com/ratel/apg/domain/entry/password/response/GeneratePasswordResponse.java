package br.com.ratel.apg.domain.entry.password.response;

import java.time.LocalDateTime;

import br.com.ratel.apg.domain.constant.PasswordStatus;
import br.com.ratel.apg.domain.constant.PasswordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GeneratePasswordResponse {
	private Long id;
	private Integer number;
	private PasswordType passwordType;
	private PasswordStatus passwordStatus;
	private LocalDateTime generationDate;
}
