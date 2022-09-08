package com.exampleportal.Controller;

import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exampleportal.Entity.MyOrder;
import com.exampleportal.Repository.UserRepository;
import com.exampleportal.Services.MyOrderService;
import com.razorpay.*;

@RestController
@RequestMapping("/payment")
@CrossOrigin("*")
public class PaymentController {
	
	@Autowired
	private MyOrderService myorderservice;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/create-order")
	public String createOrderRequest(@RequestBody Map<String,Object> data,Principal principal) throws RazorpayException {
		System.out.println(data);
		
		int amount=Integer.parseInt(data.get("amount").toString());
		
		RazorpayClient client=new RazorpayClient("rzp_test_ojOB7vbcULHWnv","4ezAfYfKFzoA7tvqRvv98v2H");
	     JSONObject obj=new JSONObject();
	     obj.put("amount", amount*100);
	     obj.put("currency", "INR");
	     obj.put("receipt", "txn_1425");
	     
	     
	     //creating razorpay order..
	     
	     Order order=client.Orders.create(obj);
	     System.out.println(order);
	     
	     //start---store order details on Database..
	     
	     MyOrder myorder=new MyOrder();
	     myorder.setAmount((Integer)order.get("amount")/100+"");
	     myorder.setOrderId(order.get("id"));
	     myorder.setPaymentId(null);
	     myorder.setReceipt(order.get("receipt"));
	     myorder.setStatus("created");
	    myorder.setDate(new Date());
	     myorder.setUser(this.userRepo.findByUsername(principal.getName()));
	     
	     this.myorderservice.saveOrder(myorder);
	     
	     // end--- store order Details to Db.
		
		return order.toString();
	}
	
	@PostMapping("/update-order")
	public ResponseEntity<?> UpdateOrder(@RequestBody Map<String,Object> data) {
		//System.out.println(data);
		
		MyOrder myorder=this.myorderservice.findOrderById(data.get("order_id").toString());
		myorder.setPaymentId(data.get("payment_id").toString());
		myorder.setStatus(data.get("status").toString());
	    this.myorderservice.saveOrder(myorder);
		return ResponseEntity.ok(Map.of("message","Payment status Updated"));
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<MyOrder>> getAllPayments(){
		
		return ResponseEntity.ok(this.myorderservice.getAllPayments());
	}
	
	

}
