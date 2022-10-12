package com.tokiobank.transference.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tokiobank.transference.business.repository.AccountRepository;
import com.tokiobank.transference.domain.entity.AccountEntity;


@Repository
public interface AccountRepositoryImpl extends CrudRepository<AccountEntity, Long>, AccountRepository {

/*	public default void  findAllTax() {
		this.
	}*/

}
