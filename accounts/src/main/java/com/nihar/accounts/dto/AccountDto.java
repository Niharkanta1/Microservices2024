package com.nihar.accounts.dto;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(name = "Account", description = "Schema to hold Account information")
public class AccountDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 246210711194336196L;

    @Schema(description = "Account Number")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digit value")
    private Long accountNumber;

    @Schema(description = "Account Type", example = "SAVINGS")
    @NotEmpty(message = "Account type can not be null or empty")
    private String accountType;

    @JsonIgnore
    private String mobileNumber;

    @Schema(description = "Branch Address")
    @NotEmpty(message = "Account branch address can not be null or empty")
    private String branchAddress;
}
