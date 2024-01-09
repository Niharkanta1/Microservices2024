package com.nihar.accounts.service.impl;

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
        if (checkCust.isPresent()) {
            throw new CustomerAlreadyExistsException(
                    "Customer already registered with the given mobile number" + customerDto.getMobileNumber());
        }
        Customer customer = customerMapper.toEntity(customerDto);
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
        return accounts;
    }

    @Override
    public List<AccountDto> findAllAccounts() {
        log.debug("Fetching all account::{}");
        return accountsRepository.findAll().stream().map(e -> accountsMapper.toDto(e)).collect(Collectors.toList());
    }

    @Override
    public AccountDto getAccountByMobileNumber(String mobileNumber) {
        log.debug("Fetching account for MobileNumber::{}", mobileNumber);
        Optional<Customer> customer = customerRepository.findByMobileNumber(mobileNumber);
        if (customer.isEmpty())
            throw new ResourceNotFoundException("Customer is not found for mobile number: " + mobileNumber);
        Optional<Account> account = accountsRepository.findByCustomerId(customer.get().getCustomerId());
        if (account.isEmpty())
            throw new ResourceNotFoundException("Account is not found for mobile number: " + mobileNumber);
        return accountsMapper.toDto(account.get());
    }

    @Override
    public void updateAccount(CustomerDto customerDto) {
        log.debug("Updating account for customer::{}", customerDto);
        var accountDto = customerDto.getAccountDto();
        if (accountDto == null) {
            throw new ResourceNotFoundException("Account Number is not found for:" + customerDto.getName());
        }
        Account account = accountsRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Account Number is not found::" + accountDto.getAccountNumber()));
        accountsMapper.updateEntity(accountDto, account);
        account = accountsRepository.save(account);
        Long custId = account.getCustomerId();
        Customer customer = customerRepository.findById(custId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer is not found for Customer id:" + custId));
        customerMapper.updateEntity(customerDto, customer);
        customerRepository.save(customer);
    }

    @Override
    public void deleteAccount(String mobileNumber) {
        log.debug("Delete account for customer with mobile number::{}", mobileNumber);
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer not found for the mobile number:" + mobileNumber));
        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
    }

}
