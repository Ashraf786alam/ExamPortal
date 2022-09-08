package com.exampleportal.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exampleportal.Entity.MyOrder;
import com.exampleportal.Repository.MyOrderRepository;
import com.exampleportal.Services.MyOrderService;

@Service
public class MyOrderServiceImpl implements MyOrderService{
	
	
	@Autowired
	private MyOrderRepository myorderRepo;

	@Override
	public MyOrder saveOrder(MyOrder myorder) {
		
		return this.myorderRepo.save(myorder);
	}

	@Override
	public MyOrder findOrderById(String orderId) {
		
		return this.myorderRepo.findByOrderId(orderId);
	}

	@Override
	public List<MyOrder> getAllPayments() {

      
		return this.myorderRepo.findAll();
	}

}
