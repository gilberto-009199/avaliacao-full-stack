package com.tokiobank.transference.api;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tokiobank.transference.api.viewmodels.AccountViewModel;

import lombok.Getter;

@RestController
@RequestMapping(path = "account")
public class AccountRestController {
	
	@GetMapping
	public ResponseEntity<?> getAccounts(){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getAccount(@PathParam("id") long id){
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> addAccount(@RequestBody @Valid AccountViewModel account){
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
