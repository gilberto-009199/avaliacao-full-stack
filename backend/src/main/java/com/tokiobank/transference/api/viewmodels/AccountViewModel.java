package com.tokiobank.transference.api.viewmodels;

import java.util.List;

import com.tokiobank.transference.business.models.AccountDto;
import com.tokiobank.transference.business.models.AccountTransferenceDto;

import jakarta.validation.constraints.NotBlank;

public class AccountViewModel{
	
	@NotBlank(message = "Account identifilter is necessary")
	private String numero;
	private String titular;
	
	private List<AccountTransferenceViewModel> listAccountTransferenceOrigin;
	private List<AccountTransferenceViewModel> listAccountTransferenceDestiny;
}
