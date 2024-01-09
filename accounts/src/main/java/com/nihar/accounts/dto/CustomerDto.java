package com.nihar.accounts.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Customer", description = "Schema to hold Customer/Account information")
public class CustomerDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 54609132502345211L;

    @Schema(description = "Customer Name", example = "John Cena")
    @NotEmpty(message = "Customer name can not be null or empty")
    @Size(min = 5, max = 30, message = "The length of customer name should be between 5 to 30")
    private String name;

    @Schema(description = "Customer Email", example = "John.Cena@email.com")
    @NotEmpty(message = "Customer email can not be null or empty")
    @Email(message = "Email address should be valid value")
    private String email;

    @Schema(description = "Customer mobile", example = "9123456780")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digit value")
    private String mobileNumber;

    private AccountDto accountDto;
}
