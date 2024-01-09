package com.nihar.accounts.mapper;

import org.mapstruct.Mapper;

import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.entity.Account;

@Mapper(componentModel = "spring")
public interface AccountsMapper extends BaseMapper<Account, AccountDto>{

}
