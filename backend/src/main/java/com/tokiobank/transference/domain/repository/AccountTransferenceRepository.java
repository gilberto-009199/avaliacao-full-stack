package com.tokiobank.transference.domain.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tokiobank.transference.domain.entities.AccountEntity;
import com.tokiobank.transference.domain.entities.AccountTransferenceEntity;

public interface AccountTransferenceRepository extends JpaRepository<AccountTransferenceEntity, UUID> {
	Optional<AccountTransferenceEntity> findById(UUID id);
	
	@Modifying
	@Query("SELECT at FROM #{#entityName} at WHERE at.accountOrigin=:id OR at.accountDestiny=:id")
	Optional<AccountEntity> findByAccountId(@Param("id") UUID id);
	
}
