package com.tokiobank.transference.api;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tokiobank.transference.api.viewmodels.AccountTransferenceViewModel;


@RestController
@RequestMapping(path = "account/transference")
public class AccountTransferenceRestController {
	
	@GetMapping
	public ResponseEntity<?> getAccountTransferences(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getAccountTransference(@PathParam("id") long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/account/{id}")
	public ResponseEntity<?> getAccountTransferencesByAccount(@PathParam("id") long idAccount){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addAccountTransference(@RequestBody @Valid AccountTransferenceViewModel account){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
