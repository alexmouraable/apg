package br.com.ratel.apg.infrastructure.jpa.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ratel.apg.domain.constant.PasswordType;
import br.com.ratel.apg.domain.constant.ServiceType;
import br.com.ratel.apg.infrastructure.jpa.entity.PasswordEntity;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntity, Long> {
	@Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END "
		+ "FROM PasswordEntity p "
		+ "WHERE p.serviceType = :serviceType "
		+ "AND p.passwordType = :passwordType "
		+ "AND p.generationDateTime BETWEEN :startOfDay AND :endOfDay")
	public boolean existsByServiceTypeAndPasswordTypeAndGenerationDate(
		@Param("serviceType") ServiceType serviceType,
		@Param("passwordType") PasswordType passwordType,
		@Param("startOfDay") LocalDateTime startOfDay,
		@Param("endOfDay") LocalDateTime endOfDay
	);

	@Query("SELECT MAX(p.number) "
		+ "FROM PasswordEntity p "
		+ "WHERE p.serviceType = :serviceType "
		+ "AND p.passwordType = :passwordType "
		+ "AND p.generationDateTime BETWEEN :startOfDay AND :endOfDay")
	public Integer findMaxPasswordNumberByServiceTypeAndPasswordTypeAndGenerationDate(
		@Param("serviceType") ServiceType serviceType,
		@Param("passwordType") PasswordType passwordType,
		@Param("startOfDay") LocalDateTime startOfDay,
		@Param("endOfDay") LocalDateTime endOfDay
	);
}
