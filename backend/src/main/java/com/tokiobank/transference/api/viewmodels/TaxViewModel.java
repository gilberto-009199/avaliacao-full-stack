package com.tokiobank.transference.api.viewmodels;

import java.math.BigDecimal;
import java.util.Date;

import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.domain.entities.TaxEntity;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TaxViewModel{
	public TaxViewModel() {}
	public TaxViewModel(TaxEntity tax) {
		this.maxDaysPerTax = tax.getMaxDaysPerTax();
		this.taxPercent = tax.getTaxPercent();
		this.maxValuePeerTax = tax.getMaxValuePeerTax();
		this.taxValue = tax.getTaxValue();
	}
	private int maxDaysPerTax;
	private BigDecimal taxPercent;
	private BigDecimal maxValuePeerTax;
	private BigDecimal taxValue;
}
