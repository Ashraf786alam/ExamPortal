package com.exampleportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exampleportal.Entity.MyOrder;

public interface MyOrderRepository extends JpaRepository<MyOrder,Integer> {
	
	public MyOrder findByOrderId(String orderId);

}
