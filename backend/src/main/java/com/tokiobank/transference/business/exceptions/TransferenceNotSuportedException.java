package com.tokiobank.transference.business.exceptions;

public class TransferenceNotSuportedException extends RuntimeException {
	public TransferenceNotSuportedException(String err) {
        super(err);
    }
}
