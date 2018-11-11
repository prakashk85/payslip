package com.au.prakash.tax.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ValidationErrorBuilder {

	private ValidationErrorBuilder() {
		// do nothing
	}

	public static ValidationError fromBindingErrors(Errors errors) {
		ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
		for (ObjectError objectError : errors.getAllErrors()) {
			if (objectError instanceof FieldError) {
				FieldError err = (FieldError) objectError;
				String fieldName = err.getField();
				error.addValidationError("Field: " + fieldName + ", Error: " + objectError.getDefaultMessage());
			} else {
				error.addValidationError(objectError.getDefaultMessage());
			}
		}
		return error;
	}
}
