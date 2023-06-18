package com.tokiobank.transference.api.viewmodels;

import java.math.BigDecimal;
import java.util.Date;


import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.business.models.AccountTransferenceDto;
import com.tokiobank.transference.domain.entities.AccountEntity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AccountTransferenceViewModel{
		
	@NotNull
	private AccountViewModel accountOrigin;

	@NotNull
	private AccountViewModel accountDestiny;
	
	/* Transactionmin tax $3 + 3%  = 3.3*/
	@DecimalMin(value = "3.04")
	private BigDecimal valueTransference;

	@NotNull
	private Date appointmentDate;
	
	private TaxEnum tax;
}
