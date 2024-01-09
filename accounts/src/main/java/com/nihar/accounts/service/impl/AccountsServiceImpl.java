package com.nihar.accounts.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nihar.accounts.constants.AccountsConstant;
import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.entity.Account;
import com.nihar.accounts.entity.Customer;
import com.nihar.accounts.exceptions.CustomerAlreadyExistsException;
import com.nihar.accounts.exceptions.ResourceNotFoundException;
import com.nihar.accounts.mapper.AccountsMapper;
import com.nihar.accounts.mapper.CustomerMapper;
import com.nihar.accounts.repository.AccountsRepository;
import com.nihar.accounts.repository.CustomerRepository;
import com.nihar.accounts.service.AccountsService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@AllArgsConstructor
public class AccountsServiceImpl implements AccountsService {
	
	private AccountsRepository accountsRepository;
	private CustomerRepository customerRepository;
	private CustomerMapper customerMapper;
	private AccountsMapper accountsMapper;

	@Override
	public void createAccount(CustomerDto customerDto) {
		log.debug("Creating account for customer::{}", customerDto);
		Optional<Customer> checkCust = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
		if(checkCust.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer already registered with the given mobile number" + customerDto.getMobileNumber());
		}
		Customer customer = customerMapper.toEntity(customerDto);
		customer.setCreatedOn(LocalDateTime.now());
		customer.setCreatedBy("SYSTEM");
		Customer savedCustomer = customerRepository.save(customer);
		accountsRepository.save(createNewAccount(savedCustomer));
	}

	private Account createNewAccount(Customer customer) {
		Account accounts = new Account();
		accounts.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 1000000000 + new Random().nextInt(900000000);
		accounts.setAccountNumber(randomAccNumber);
		accounts.setAccountType(AccountsConstant.SAVINGS);
		accounts.setMobileNumber(customer.getMobileNumber());
		accounts.setBranchAddress(AccountsConstant.ADDRESS);
		accounts.setCreatedOn(LocalDateTime.now());
		accounts.setCreatedBy(customer.getCreatedBy());
		return accounts;
	}

	@Override
	public List<AccountDto> findAllAccounts() {
		return accountsRepository.findAll()
				.stream().map(e -> accountsMapper.toDto(e))
				.collect(Collectors.toList());
	}

	@Override
	public AccountDto getAccountByMobileNumber(String mobileNumber) {
		Optional<Customer> customer = customerRepository.findByMobileNumber(mobileNumber);
		if(customer.isEmpty())
			throw new ResourceNotFoundException("Customer is not found for mobile number: "+mobileNumber);
	 	Optional<Account> account = accountsRepository.findByCustomerId(customer.get().getCustomerId());
	 	if(account.isEmpty())
			throw new ResourceNotFoundException("Account is not found for mobile number: "+mobileNumber);
		return accountsMapper.toDto(account.get());
	}
	
}
