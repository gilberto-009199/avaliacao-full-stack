package com.tokiobank.transference.api.viewmodels;

import java.util.List;

import com.tokiobank.transference.domain.entities.AccountEntity;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AccountViewModel{
	
	public AccountViewModel() {}
	public AccountViewModel(AccountEntity accountOrigin) {
		this.titular = accountOrigin.getTitular();
		this.numero = accountOrigin.getNumero();
	}
	@NotBlank(message = "Account identifilter is necessary")
	private String numero;
	private String titular;
	
	
	
	private List<AccountTransferenceViewModel> listAccountTransferenceOrigin;
	private List<AccountTransferenceViewModel> listAccountTransferenceDestiny;
}
