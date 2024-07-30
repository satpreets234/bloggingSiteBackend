package com.blogging_site.practice.exceptions;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	private String model;
	private String exceptionKey;
	private String exceptionValue;
	
	public ResourceNotFoundException(String model,String exceptionKey,String exceptionValue) {
		super(String.format("%s not found with %s with value %s", model, exceptionKey,exceptionValue));
		this.model=model;
		this.exceptionKey=exceptionKey;
		this.exceptionValue=exceptionValue;
	}
}
