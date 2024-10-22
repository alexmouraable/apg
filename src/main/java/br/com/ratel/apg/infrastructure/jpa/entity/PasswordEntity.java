package br.com.ratel.apg.infrastructure.jpa.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ratel.apg.domain.constant.PasswordStatus;
import br.com.ratel.apg.domain.constant.PasswordType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ChamadaSenha")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PasswordEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Cod_Senha")
	private Long id;
	
	@Column(name = "Num_Senha")
	private Integer number;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Tipo_Senha")
	private PasswordType passwordType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "Sit_Senha")
	private PasswordStatus passwordStatus;
	
	@Column(name = "Data_Senha")
	private LocalDate generationDate;
}