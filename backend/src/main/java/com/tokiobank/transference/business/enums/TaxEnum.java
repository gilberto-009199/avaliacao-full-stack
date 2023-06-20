package com.tokiobank.transference.business.enums;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;
import com.tokiobank.transference.api.viewmodels.TaxViewModel;
import com.tokiobank.transference.domain.entities.AccountTransferenceEntity;
import com.tokiobank.transference.domain.entities.TaxEntity;

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
	
	public static TaxEnum calc(AccountTransferenceViewModel transference) {
		return calc(new AccountTransferenceEntity().withAppointmentDate(transference.getAppointmentDate()).withValueTransference(transference.getValueTransference()));
	}
	public static TaxEnum calc(AccountTransferenceEntity transference) {
		// logic calc
		
		long daysBetween = ChronoUnit.DAYS.between( LocalDate.now() , transference.getAppointmentDate());
		
		TaxEnum tax = A;
		
		if(daysBetween <=  A.maxDaysPerTax){
            tax = A;
        }else if(daysBetween <= B.maxDaysPerTax){
        	tax = B;
        }else if(daysBetween <= C.maxDaysPerTax){
            tax = C;
        }else if(daysBetween <= C2.maxDaysPerTax){
        	tax = C2;
        }else if(daysBetween <= C3.maxDaysPerTax){
        	tax = C3;
        }else if(daysBetween > C4.maxDaysPerTax){
        	tax = C4;
        }
		
        // if's max value
        if( transference.getValueTransference().compareTo(A.maxValuePeerTax) == 1 &&
        	transference.getValueTransference().compareTo(B.maxValuePeerTax) == -1 ){
        	tax = B;
        }else if( transference.getValueTransference().compareTo(B.maxValuePeerTax) == 1 &&
        		  transference.getValueTransference().compareTo(C.maxValuePeerTax) == 1){
            if(daysBetween <= TaxEnum.C.maxDaysPerTax){
            	tax = C;
            }else if(daysBetween <= TaxEnum.C2.maxDaysPerTax){
            	tax = C2;
            }else if(daysBetween <= TaxEnum.C3.maxDaysPerTax){
            	tax = C3;
            }else if(daysBetween > TaxEnum.C4.maxDaysPerTax){
            	tax = C4;
            }
        }
		
		return tax;
	}

	// requirements
	private int maxDaysPerTax;
	private BigDecimal maxValuePeerTax;

	// cost 
	private BigDecimal taxPercent;
	private BigDecimal taxValue;
	public int getMaxDaysPerTax() {
		return maxDaysPerTax;
	}

	public void setMaxDaysPerTax(int maxDaysPerTax) {
		this.maxDaysPerTax = maxDaysPerTax;
	}

	public BigDecimal getMaxValuePeerTax() {
		return maxValuePeerTax;
	}

	public void setMaxValuePeerTax(BigDecimal maxValuePeerTax) {
		this.maxValuePeerTax = maxValuePeerTax;
	}

	public BigDecimal getTaxPercent() {
		return taxPercent;
	}

	public void setTaxPercent(BigDecimal taxPercent) {
		this.taxPercent = taxPercent;
	}

	public BigDecimal getTaxValue() {
		return taxValue;
	}

	public void setTaxValue(BigDecimal taxValue) {
		this.taxValue = taxValue;
	}
	
}
