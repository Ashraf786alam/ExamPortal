package com.exampleportal.Services;

import java.util.List;

import com.exampleportal.Entity.MyOrder;

public interface MyOrderService {
	
	public MyOrder saveOrder(MyOrder myorder);
	
	public MyOrder  findOrderById(String orderId);
	
	public List<MyOrder> getAllPayments();

}
