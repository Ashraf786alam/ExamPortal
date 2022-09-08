package com.exampleportal.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.Request;
import com.exampleportal.Helper.RequestDto;
import com.exampleportal.Repository.RequestRepository;
import com.exampleportal.Services.RequestService;

@Service
public class RequestServiceImpl implements RequestService{
	
	@Autowired
	private RequestRepository requestRepo;

	@Override
	public Request addRequest(Request request) {

      this.requestRepo.save(request);
		return request;
	}

	@Override
	public List<RequestDto> getAllRequest() {

		List<Request> requests=this.requestRepo.findAll();
		
		ArrayList<RequestDto> requestDtos=new ArrayList<RequestDto>();
		
	   
	  requests.stream().forEach((request)->{
		  RequestDto requestDto=new RequestDto();
		  requestDto.setContent(request.getContent());
		  requestDto.setDate(request.getDate());
		  requestDto.setEmail(request.getUser().getEmail());
		  requestDto.setPhone(request.getUser().getPhone());
		  requestDto.setRequestId(request.getRequestId());
		  requestDto.setUserId(request.getUser().getId());
		  requestDto.setUsername(request.getUser().getUsername());
		  requestDto.setAction("Reply");
		  requestDtos.add(requestDto);
		  
	  });
            
	  return requestDtos;
		
	}

	@Override
	public List<RequestDto> deleteRequest(int requestId) {
		this.requestRepo.deleteById(requestId);
		return this.getAllRequest();
	}

}
