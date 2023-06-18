package com.tokiobank.transference.business.models;

import java.util.List;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;
import lombok.Data;

@Data
public class AccountDto {
	private String titular;
	private String numero;
	private List<AccountTransferenceDto> listAccountTransferenceOrigin;
	private List<AccountTransferenceDto> listAccountTransferenceDestiny;
}
