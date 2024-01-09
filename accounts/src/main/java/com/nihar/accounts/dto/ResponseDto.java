package com.nihar.accounts.dto;

import java.io.Serializable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Response", description = "Schema to hold Response information")
public class ResponseDto implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1337510903915968306L;

    @Schema(description = "Status Code", example = "200, 500 etc")
    private String statusCode;
    @Schema(description = "Status Message")
    private String statusMessage;
}
