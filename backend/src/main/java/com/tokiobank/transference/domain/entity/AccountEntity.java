package com.tokiobank.transference.domain.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.tokiobank.transference.business.models.Account;

import lombok.Data;

@Data
@Entity
@Table(name = "tbl_account")
public class AccountEntity extends BaseEntity implements Account{
	
	@Column(updatable = false)
	private String account;
	
	@OneToMany(mappedBy = "accountOrigin")
	private List<AccountTransferenceEntity> listAccountTransferenceOrigin;
	
	@OneToMany(mappedBy = "accountDestiny")
	private List<AccountTransferenceEntity> listAccountTransferenceDestiny;

}
