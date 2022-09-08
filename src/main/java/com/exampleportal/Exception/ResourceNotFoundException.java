package com.exampleportal.Exception;

public class ResourceNotFoundException extends RuntimeException{
    
	private String resource;
	private String fieldName;
	private String fieldValue;
	
	
	
	
	
	public ResourceNotFoundException(String resource, String fieldName, String fieldValue) {
		super(String.format("%s not found with %s : %s",resource,fieldName,fieldValue));
		this.resource = resource;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}
	
	
	
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getFiledName() {
		return fieldName;
	}
	public void setFiledName(String filedName) {
		this.fieldName = filedName;
	}
	public String getFieldValue() {
		return fieldValue;
	}
	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
}
