package com.tokiobank.transference.domain.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.tokiobank.transference.business.enums.TaxEnum;
import com.tokiobank.transference.business.models.AccountTransference;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_account_transference")
public class AccountTransferenceEntity extends BaseEntity implements AccountTransference{

	@ManyToOne
	@JoinColumn(name="accountOrigin")
	private AccountEntity accountOrigin;

	@ManyToOne
	@JoinColumn(name="accountDestiny")
	private AccountEntity accountDestiny;
	
	@Embedded
	private TaxEnum tax;
	
	@Column(updatable = false)
	private Date appointmentDate;

	
}
