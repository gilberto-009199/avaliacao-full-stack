package com.tokiobank.transference.business.enums;

import java.math.BigDecimal;

public enum TaxEnum {
	
	// ( day , valueMax, tax percent, tax value)
	A(	1,	0000,	3.0,	00.3),
	B(	10,	0000,	0.0,	12.0),
	C(	20,	0000,	8.2,	00.0),
	C2(	30,	0000,	4.7,	00.0),
	C3(	40,	0000,	1.7,	00.0),
	D(	0,	1000,	3.0,	00.3),
	D2(	0,	1001,	0.0,	12.0),
	D3(	0,	2001,	1.7,	00.0);
	
	static final int MAX_TAX_PER_DAY = C3.maxDaysPerTax;
	
	TaxEnum(int days, int maxValue, double percent, int value) {
		this.maxDaysPerTax = days;
		this.taxPercent = BigDecimal.valueOf(percent);
		this.maxValuePeerTax = BigDecimal.valueOf(maxValue);
		this.taxValue = BigDecimal.valueOf(value);
	}
	TaxEnum(int days, double maxValue, double percent, double value) {
		this.maxDaysPerTax = days;
		this.taxPercent = BigDecimal.valueOf(percent);
		this.maxValuePeerTax = BigDecimal.valueOf(maxValue);
		this.taxValue = BigDecimal.valueOf(value);
	}
	
	// requirements
	private int maxDaysPerTax;
	private BigDecimal maxValuePeerTax;

	// cost 
	private BigDecimal taxPercent;
	private BigDecimal taxValue;
	
}
