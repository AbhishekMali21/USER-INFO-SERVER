package com.exception;

import lombok.Data;

@Data
public class ResourceNotFoundException extends RuntimeException {

	String resourceName;
	String fieldName;
	String fieldValue;

	public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s: with email id as: %s", resourceName, fieldName, fieldValue));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

}