package com.nihar.accounts.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class AccountDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 246210711194336196L;
	
	private Long accountNumber;

	private String accountType;
	
	@JsonIgnore
	private String mobileNumber;
	
	private String branchAddress;
}
