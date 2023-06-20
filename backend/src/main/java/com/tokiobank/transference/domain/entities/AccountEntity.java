package com.tokiobank.transference.domain.entities;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tokiobank.transference.api.viewmodels.AccountViewModel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "tbl_account")
public class AccountEntity extends BaseEntity{
	
	@Column(updatable = false)
	private String titular;
	
	@Column(updatable = false)
	private String numero;
	
	@OneToMany(targetEntity = AccountTransferenceEntity.class, fetch = FetchType.LAZY, mappedBy = "accountOrigin", cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("accountDestiny")
	private List<AccountTransferenceEntity> listAccountTransferenceOrigin;
	
	@OneToMany(targetEntity = AccountTransferenceEntity.class, fetch = FetchType.LAZY, mappedBy = "accountDestiny", cascade = CascadeType.ALL)
	//@JsonIgnoreProperties("accountOrigin")
	private List<AccountTransferenceEntity> listAccountTransferenceDestiny;

	public AccountEntity() {}
	public AccountEntity(AccountViewModel model) {
		this.titular = model.getTitular();
		this.numero = model.getNumero();
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<AccountTransferenceEntity> getListAccountTransferenceOrigin() {
		return listAccountTransferenceOrigin;
	}

	public void setListAccountTransferenceOrigin(List<AccountTransferenceEntity> listAccountTransferenceOrigin) {
		this.listAccountTransferenceOrigin = listAccountTransferenceOrigin;
	}

	public List<AccountTransferenceEntity> getListAccountTransferenceDestiny() {
		return listAccountTransferenceDestiny;
	}

	public void setListAccountTransferenceDestiny(List<AccountTransferenceEntity> listAccountTransferenceDestiny) {
		this.listAccountTransferenceDestiny = listAccountTransferenceDestiny;
	};

	
	
}
