package com.tokiobank.transference.api;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiobank.transference.api.viewmodels.AccountViewModel;
import com.tokiobank.transference.domain.entities.AccountEntity;
import com.tokiobank.transference.domain.repository.AccountRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping(path = "account")
public class AccountRestController {
	
	@Autowired
	public AccountRepository repository; 
	
	@GetMapping
	public ResponseEntity<?> getAccounts(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping(path = "/{numero}")
	public ResponseEntity<?> getAccount(@PathVariable("numero") String numero){
		Optional<AccountEntity> entity = repository.findByAccountNumber(numero);
		return ResponseEntity.ok(entity);
	}
	
	@PostMapping
	public ResponseEntity<?> addAccount(@RequestBody @Valid AccountViewModel account){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
