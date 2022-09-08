package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.Request;
import com.exampleportal.Helper.RequestDto;

public interface RequestService {
	
	public Request addRequest(Request request);
	
	public List<RequestDto> getAllRequest();
	
	public List<RequestDto> deleteRequest(int requestId);

}
