package br.com.ratel.apg.infrastructure.jpa.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.infrastructure.jpa.entity.PasswordEntity;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntity, Long> {
	public boolean existsByPasswordTypeAndGenerationDate(PasswordType passwordType, LocalDate date);

	@Query("SELECT MAX(p.number) FROM PasswordEntity p WHERE p.passwordType = :passwordType AND p.generationDate = :date")
	public Integer findMaxPasswordNumberByPasswordTypeAndGenerationDate(
			@Param("passwordType") PasswordType passwordType, @Param("date") LocalDate date);
}
