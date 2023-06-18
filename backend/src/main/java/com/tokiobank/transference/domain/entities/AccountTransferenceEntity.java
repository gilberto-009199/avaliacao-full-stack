package com.tokiobank.transference.domain.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.validator.internal.util.stereotypes.Lazy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tokiobank.transference.business.enums.TaxEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "tbl_account_transference")
public class AccountTransferenceEntity extends BaseEntity{

	@ManyToOne(targetEntity = AccountEntity.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="accountOrigin")
	@JsonIgnoreProperties(value =  {"listAccountTransferenceDestiny","listAccountTransferenceOrigin"})
	private AccountEntity accountOrigin;

	@ManyToOne(targetEntity = AccountEntity.class, cascade = CascadeType.ALL)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name="accountDestiny")
	@JsonIgnoreProperties(value =  {"listAccountTransferenceDestiny","listAccountTransferenceOrigin"})
	private AccountEntity accountDestiny;
	
	@Column
	private BigDecimal valueTransference;
	
	@Embedded
	private TaxEntity tax;
	
	@Column(updatable = false)
	private LocalDate appointmentDate;

	public AccountEntity getAccountOrigin() {
		return accountOrigin;
	}

	public void setAccountOrigin(AccountEntity accountOrigin) {
		this.accountOrigin = accountOrigin;
	}

	public AccountEntity getAccountDestiny() {
		return accountDestiny;
	}

	public void setAccountDestiny(AccountEntity accountDestiny) {
		this.accountDestiny = accountDestiny;
	}

	public BigDecimal getValueTransference() {
		return valueTransference;
	}

	public void setValueTransference(BigDecimal valueTransference) {
		this.valueTransference = valueTransference;
	}

	public TaxEntity getTax() {
		return tax;
	}

	public void setTax(TaxEntity tax) {
		this.tax = tax;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
		
}
