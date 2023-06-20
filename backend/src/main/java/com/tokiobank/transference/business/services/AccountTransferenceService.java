package com.tokiobank.transference.business.services;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;

import jakarta.validation.Valid;

public interface AccountTransferenceService {

	AccountTransferenceViewModel create(AccountTransferenceViewModel account);
}
