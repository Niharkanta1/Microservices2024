package com.nihar.accounts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/customer")
@AllArgsConstructor
public class CustomerController {
	
	private CustomerService customerService;

	@GetMapping("/fetch")
	public ResponseEntity<CustomerDto> getAccountByMobileNumber(@RequestParam String mobileNumber) {
		CustomerDto details = customerService.getCustomerDetailsByMobileNumber(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(details);
	}
}
