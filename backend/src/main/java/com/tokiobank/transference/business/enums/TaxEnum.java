package com.tokiobank.transference.business.enums;

import java.math.BigDecimal;

public enum TaxEnum {

	// ( max day , max value, tax percent, tax value)
	A(	1,	1000,	3.0,	 3.0),
	B(	10,	2000,	0.0,	12.0),
	C(	20,	0000,	8.2,	00.0),
	C2(	30,	0000,	6.9,	00.0),
	C3(	40,	0000,	4.7,	00.0),
	C4(	 0,	0000,	1.7,	00.0);
	// D = max value

	TaxEnum(int days, double maxValue, double percent,  double value) {
		this.maxDaysPerTax = days;
		this.taxPercent = BigDecimal.valueOf(percent);
		this.maxValuePeerTax = BigDecimal.valueOf(maxValue);
		this.taxValue = BigDecimal.valueOf(value);
	}
	
	public static BigDecimal calc(BigDecimal amount, TaxEnum tax) {	return TaxEnum.calc(amount, tax.maxDaysPerTax, tax.taxPercent, tax.maxValuePeerTax, tax.taxValue);}
	public static BigDecimal calc(BigDecimal amount, int days, BigDecimal maxValue, BigDecimal percent,  BigDecimal value) {
		
		// logic calc
		
		return null;
	}

	// requirements
	private int maxDaysPerTax;
	private BigDecimal maxValuePeerTax;

	// cost 
	private BigDecimal taxPercent;
	private BigDecimal taxValue;
	
}
