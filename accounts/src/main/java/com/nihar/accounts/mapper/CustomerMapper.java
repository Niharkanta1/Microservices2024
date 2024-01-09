package com.nihar.accounts.mapper;

import org.mapstruct.Mapper;

import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto>{
	
}
