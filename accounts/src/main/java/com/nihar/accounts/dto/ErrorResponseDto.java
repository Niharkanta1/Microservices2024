package com.nihar.accounts.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Error", description = "Schema to hold Error information")
public class ErrorResponseDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 885001058348372902L;

    @Schema(description = "API Path")
    private String apiPath;
    @Schema(description = "Error Code")
    private HttpStatus errorCode;
    @Schema(description = "Error Message")
    private String errorMessage;
    @Schema(description = "Time of Error")
    private LocalDateTime errorTime;
}
