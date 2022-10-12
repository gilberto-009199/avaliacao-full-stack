package com.tokiobank.transference.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tokiobank.transference.business.repository.AccountTransferenceRepository;
import com.tokiobank.transference.domain.entity.AccountEntity;

@Repository
public interface AcoountTransferenceRepositoryImpl extends CrudRepository<AccountEntity, Long>, AccountTransferenceRepository {}
