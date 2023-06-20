package com.tokiobank.transference.api.viewmodels;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.domain.entities.AccountEntity;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;


@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class AccountTransferenceViewModel{
		
	@NotNull
	private AccountViewModel accountOrigin;

	@NotNull
	private AccountViewModel accountDestiny;
	
	/* Transactionmin tax $3 + 3%  = 3.3*/
	@DecimalMin(value = "3.3")
	private BigDecimal valueTransference;

	@NotNull
	private LocalDate appointmentDate;
	
	private TaxViewModel tax;
}
