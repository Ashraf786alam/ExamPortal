package com.exampleportal.Exception;

public class UserAlreadyExistsException extends Exception {
	
	private String resource;
	public UserAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getResource() {
		return resource;
	}
	public void setResource(String resource) {
		this.resource = resource;
	}
	public String getResourceValue() {
		return resourceValue;
	}
	public void setResourceValue(String resourceValue) {
		this.resourceValue = resourceValue;
	}
	public UserAlreadyExistsException(String resource, String resourceValue) {
		super(String.format("%s already exist with username: %s",resource,resourceValue));
		this.resource = resource;
		this.resourceValue = resourceValue;
	}
	private String resourceValue;

}
