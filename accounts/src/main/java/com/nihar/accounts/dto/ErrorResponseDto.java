package com.nihar.accounts.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorResponseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 885001058348372902L;

	private String apiPath;
	private HttpStatus errorCode;
	private String errorMessage;
	private LocalDateTime errorTime;
}
