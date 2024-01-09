package com.nihar.accounts.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.entity.Account;
import com.nihar.accounts.entity.Customer;
import com.nihar.accounts.exceptions.ResourceNotFoundException;
import com.nihar.accounts.mapper.AccountsMapper;
import com.nihar.accounts.mapper.CustomerMapper;
import com.nihar.accounts.repository.AccountsRepository;
import com.nihar.accounts.repository.CustomerRepository;
import com.nihar.accounts.service.CustomerService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
	
	private CustomerRepository customerRepository;
	private AccountsRepository accountsRepository;
	private CustomerMapper customerMapper;
	private AccountsMapper accountsMapper;

	@Override
	public CustomerDto getCustomerDetailsByMobileNumber(String mobileNumber) {
		Optional<Customer> customer = customerRepository.findByMobileNumber(mobileNumber);
		if(customer.isEmpty())
			throw new ResourceNotFoundException("Customer is not found for mobile number: "+mobileNumber);
	 	Optional<Account> account = accountsRepository.findByCustomerId(customer.get().getCustomerId());
	 	if(account.isEmpty())
			throw new ResourceNotFoundException("Account is not found for mobile number: "+mobileNumber);
	 	CustomerDto customerDto = customerMapper.toDto(customer.get());
	 	customerDto.setAccountDto(accountsMapper.toDto(account.get()));
		return customerDto;
	}

}
