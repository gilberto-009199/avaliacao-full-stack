package com.tokiobank.transference.business.models;

import java.math.BigDecimal;
import java.util.Date;

import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.domain.entities.AccountEntity;

import lombok.Data;

@Data
public class AccountTransferenceDto {
	private AccountDto accountOrigin;
	private AccountDto accountDestiny;
	private BigDecimal valueTransference;
	private Date appointmentDate;
	private TaxEnum tax;
}
