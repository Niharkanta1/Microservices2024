package com.nihar.accounts.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.nihar.accounts.constants.AccountsConstant;
import com.nihar.accounts.dto.AccountDto;
import com.nihar.accounts.dto.CustomerDto;
import com.nihar.accounts.dto.ErrorResponseDto;
import com.nihar.accounts.dto.ResponseDto;
import com.nihar.accounts.service.AccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

@Tag(name = "CRUD REST APIs for Accounts",
        description = "CRUD operations for accounts i.e CREATE, UPDATE, FETCH and DELETE")
@RestController
@RequestMapping(path = "/api/account", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class AccountsController {

    private AccountsService accountsService;

    @Operation(summary = "Create Account REST API", description = "API Specification for creating Account and Customer")
    @ApiResponse(responseCode = "201", description = "HTTP Status CREATED")
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.createAccount(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstant.STATUS_201, AccountsConstant.MESAGE_201));
    }

    @Operation(summary = "Fetch Accounts REST API", description = "API Specification for fetching all Accounts")
    @ApiResponse(responseCode = "200", description = "HTTP Status OK")
    @GetMapping("")
    public ResponseEntity<List<AccountDto>> getAccounts() {
        List<AccountDto> accounts = accountsService.findAllAccounts();
        return ResponseEntity.status(HttpStatus.OK).body(accounts);
    }

    @Operation(summary = "Fetch Account REST API",
            description = "API Specification for fetching Account by mobile number")
    @ApiResponse(responseCode = "200", description = "HTTP Status OK")
    @GetMapping("/fetch")
    public ResponseEntity<AccountDto> getAccountByMobileNumber(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digit value") String mobileNumber) {
        AccountDto account = accountsService.getAccountByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(account);
    }

    @Operation(summary = "Update Account/Customer REST API",
            description = "API Specification for Update Account or customer")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "HTTP Status OK"),
            @ApiResponse(responseCode = "500", description = "HTTP Status Internal Server Error",
                    content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @PutMapping("")
    public ResponseEntity<ResponseDto> updateAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountsService.updateAccount(customerDto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESAGE_200));
    }

    @Operation(summary = "Delete Account/Customer REST API",
            description = "API Specification for delete Account and Customer by mobile number")
    @ApiResponse(responseCode = "200", description = "HTTP Status OK")
    @DeleteMapping("")
    public ResponseEntity<ResponseDto> deleteAccount(@RequestParam @Pattern(regexp = "(^$|[0-9]{10})",
            message = "Mobile number must be 10 digit value") String mobileNumber) {
        accountsService.deleteAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstant.STATUS_200, AccountsConstant.MESAGE_200));
    }
}
