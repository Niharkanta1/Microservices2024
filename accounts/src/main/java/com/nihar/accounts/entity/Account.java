package com.nihar.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Account extends BaseEntity {

	@Id
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private Long customerId;
	
	@Column(name = "account_type")
	private String accountType;
	
	@Column(name = "mobile_number")
	private String mobileNumber;
	
	@Column(name="branch_address")
	private String branchAddress;
}
