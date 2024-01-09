package com.nihar.accounts.service;

import com.nihar.accounts.dto.CustomerDto;


public interface CustomerService {

    CustomerDto getCustomerDetailsByMobileNumber(String mobileNumber);
}
