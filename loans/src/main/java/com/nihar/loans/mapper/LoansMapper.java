package com.nihar.loans.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import com.nihar.loans.dto.LoansDto;
import com.nihar.loans.entity.Loans;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoansMapper extends BaseMapper<Loans, LoansDto> {

}
