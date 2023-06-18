package com.tokiobank.transference.domain.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.tokiobank.transference.business.enums.TaxEnum;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class TaxEntity{
	private int maxDaysPerTax;
	private double taxPercent;
	private double maxValuePeerTax;
	private double taxValue;
}
