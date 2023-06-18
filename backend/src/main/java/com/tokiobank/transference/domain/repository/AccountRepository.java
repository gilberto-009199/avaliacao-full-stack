package com.tokiobank.transference.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tokiobank.transference.domain.entities.AccountEntity;

import jakarta.transaction.Transactional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	Optional<AccountEntity> findById(UUID id);

	@Transactional
	@Query("SELECT a FROM #{#entityName} a WHERE a.numero=:numero")
	Optional<AccountEntity> findByAccountNumber(@Param("numero") String numero);
}
