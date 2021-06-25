package com.distareza.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.distareza.jpa.dto.OrderRequest;
import com.distareza.jpa.entity.Customer;
import com.distareza.jpa.repository.CustomerRepository;
import com.distareza.jpa.repository.ProductRepository;

@Controller
public class OrderController {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private ProductRepository productRepo;
	
	@PostMapping("/placeOrder")
	public Customer placeOrder(@RequestBody OrderRequest request) {
		return customerRepo.save(request.getCustomer());
	}
}
