package com.nihar.accounts.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nihar.accounts.constants.AccountsConstant;
import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.dto.ResponseDto;
import com.nihar.accounts.service.AccountsService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {
	
	private AccountsService accountsService;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
		accountsService.createAccount(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESAGE_201));
	}
	
	@GetMapping("")
	public ResponseEntity<List<AccountDto>> getAccounts() {
		List<AccountDto> accounts = accountsService.findAllAccounts();
		return ResponseEntity.status(HttpStatus.OK).body(accounts);
	}
	
	@GetMapping("/fetch")
	public ResponseEntity<AccountDto> getAccountByMobileNumber(@RequestParam String mobileNumber) {
		AccountDto account = accountsService.getAccountByMobileNumber(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(account);
	}
}
