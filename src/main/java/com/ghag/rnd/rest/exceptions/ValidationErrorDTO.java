package com.ghag.rnd.rest.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrorDTO {
	
	Map<String, String> validationErrors = new HashMap<String, String>();

	public void addFieldError(String field, String errorMessage){
		validationErrors.put(field, errorMessage);
	}

	public Map<String, String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(Map<String, String> validationErrors) {
		this.validationErrors = validationErrors;
	}

	@Override
	public String toString() {
		return "ValidationErrorDTO [validationErrors=" + validationErrors + "]";
	}
	
	
	
	
}
