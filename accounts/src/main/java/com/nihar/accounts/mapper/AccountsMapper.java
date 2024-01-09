package com.nihar.accounts.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.entity.Account;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountsMapper extends BaseMapper<Account, AccountDto>{

}
