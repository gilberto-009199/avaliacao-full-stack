package com.tokiobank.transference.domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.tokiobank.transference.api.viewmodels.TaxViewModel;
import com.tokiobank.transference.business.enums.TaxEnum;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TaxEntity{

	public TaxEntity() {}
	public TaxEntity(TaxViewModel tax) {
		this.maxDaysPerTax = tax.getMaxDaysPerTax();
		this.taxPercent = tax.getTaxPercent();
		this.maxValuePeerTax = tax.getMaxValuePeerTax();
		this.taxValue = tax.getTaxValue();
	}
	public TaxEntity(TaxEnum tax) {
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
