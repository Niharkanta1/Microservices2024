package com.nihar.accounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.entity.Customer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CustomerMapper extends BaseMapper<Customer, CustomerDto>{
	
}
