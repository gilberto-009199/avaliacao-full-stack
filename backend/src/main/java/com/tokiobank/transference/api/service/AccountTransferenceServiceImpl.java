package com.tokiobank.transference.api.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;
import com.tokiobank.transference.api.viewmodels.AccountViewModel;
import com.tokiobank.transference.api.viewmodels.TaxViewModel;
import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.business.services.AccountTransferenceService;
import com.tokiobank.transference.domain.entities.AccountEntity;
import com.tokiobank.transference.domain.entities.AccountTransferenceEntity;
import com.tokiobank.transference.domain.repository.AccountRepository;
import com.tokiobank.transference.domain.repository.AccountTransferenceRepository;

import jakarta.transaction.Transactional;


@Service
public class AccountTransferenceServiceImpl implements AccountTransferenceService {
	
	@Autowired
	public AccountTransferenceRepository repository;
	
	@Autowired
	public AccountRepository repositoryAccount;
	
	@Transactional
	public AccountTransferenceViewModel create(AccountTransferenceViewModel accountTransference) {
		
		boolean appointmentDateLessDateNow = LocalDate.now().isAfter( accountTransference.getAppointmentDate() );
		
		if(appointmentDateLessDateNow)throw new RuntimeException("Transação não suportada!");
		
		AccountTransferenceEntity entity = new AccountTransferenceEntity();
		
		Optional<AccountEntity> entityOrigin = repositoryAccount.findByAccountNumber(accountTransference.getAccountOrigin().getNumero());
		Optional<AccountEntity> entityDestiny = repositoryAccount.findByAccountNumber(accountTransference.getAccountDestiny().getNumero());
				
		entity.withValueTransference(accountTransference.getValueTransference())
		.withAccountOrigin(entityOrigin.get())
		.withAccountDestiny(entityDestiny.get())
		.withAppointmentDate(accountTransference.getAppointmentDate())
		.withTax(TaxEnum.calc(accountTransference));
		
		if( repository.save(entity) == null) {
			throw new RuntimeException("Erro na Operação de escrita");
		};
		
		return new AccountTransferenceViewModel().withAccountOrigin( new AccountViewModel( entity.getAccountOrigin() ) )
				.withAccountDestiny(new AccountViewModel( entity.getAccountDestiny() ))
				.withAppointmentDate(entity.getAppointmentDate())
				.withValueTransference(entity.getValueTransference())
				.withTax(new TaxViewModel( entity.getTax() ));
	}
}
