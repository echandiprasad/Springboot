package com.sb.restapi.model;

public class CustomException {

	private String errorMessage;

	public CustomException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
