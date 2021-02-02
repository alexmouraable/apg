package br.com.ratel.apg.infrastructure.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ratel.apg.infrastructure.jpa.entity.PasswordEntity;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntity, Long> {

}
