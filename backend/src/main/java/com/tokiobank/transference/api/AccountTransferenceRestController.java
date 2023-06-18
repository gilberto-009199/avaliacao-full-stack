package com.tokiobank.transference.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;
import com.tokiobank.transference.domain.repository.AccountTransferenceRepository;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;


@RestController
@RequestMapping(path = "account/transference")
public class AccountTransferenceRestController {
	
	@Autowired
	public AccountTransferenceRepository repository;
	
	@GetMapping
	public ResponseEntity<?> getAccountTransferences(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getAccountTransference(@PathParam("id") long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addAccountTransference(@RequestBody @Valid AccountTransferenceViewModel account){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
