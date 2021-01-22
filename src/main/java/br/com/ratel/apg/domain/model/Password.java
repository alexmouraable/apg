package br.com.ratel.apg.domain.model;

import java.time.LocalDateTime;

import br.com.ratel.apg.domain.type.PasswordType;
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
	private Integer number;
	private PasswordType passwordType;
	private LocalDateTime generationDateAndTime;
}