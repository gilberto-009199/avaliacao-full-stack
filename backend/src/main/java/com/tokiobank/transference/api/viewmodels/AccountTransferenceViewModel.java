package com.tokiobank.transference.api.viewmodels;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.business.models.AccountTransference;
import com.tokiobank.transference.domain.entity.AccountEntity;

import lombok.Data;

@Data
public class AccountTransferenceViewModel implements AccountTransference{
		
	@NotNull
	private AccountEntity accountOrigin;

	@NotNull
	private AccountEntity accountDestiny;
	
	/* Transactionmin tax $3 + 3%  = 3.3*/
	@DecimalMin(value = "3.04")
	private BigDecimal valueTransference;

	@NotNull
	private Date appointmentDate;
	
	private TaxEnum tax;
}
