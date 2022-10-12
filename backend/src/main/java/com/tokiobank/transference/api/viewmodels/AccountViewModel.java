package com.tokiobank.transference.api.viewmodels;

import javax.validation.constraints.NotBlank;

import com.tokiobank.transference.business.models.Account;

public class AccountViewModel implements Account{
	
	@NotBlank(message = "Account identifilter is necessary")
	private String account;
	
}
