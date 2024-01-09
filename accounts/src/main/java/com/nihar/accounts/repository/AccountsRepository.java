package com.nihar.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nihar.accounts.entity.Account;

public interface AccountsRepository extends JpaRepository<Account, Long> {

	Optional<Account> findByMobileNumber(String mobileNumber);
	Optional<Account> findByCustomerId(Long custId);

}
