package com.nihar.accounts.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ResponseDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1337510903915968306L;

	private String statusCode;
	private String statusMessage;
}
