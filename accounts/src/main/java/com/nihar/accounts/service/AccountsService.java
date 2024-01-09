package com.nihar.accounts.service;

import java.util.List;

import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.dto.CustomerDto;

public interface AccountsService {
	
	void createAccount(CustomerDto customerDto);
	List<AccountDto> findAllAccounts();
	AccountDto getAccountByMobileNumber(String mobileNumber);
}
