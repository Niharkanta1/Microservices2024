package com.nihar.accounts.dto;

import java.io.Serializable;

import com.nihar.accounts.entity.Account;

import lombok.Data;

@Data
public class CustomerDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 54609132502345211L;

	private String name;

	private String email;

	private String mobileNumber;
	
	private AccountDto accountDto;
}
