package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.sales.models.Order;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.OrderRepository;

public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

	// this method gets all the Orders from the database
	public ArrayList<Order> getOrders() {
		return (ArrayList<Order>) orderRepository.findAll();
	}
	
	//this method will save the new customer details
	public Order save(Order order) {

		//Passes order object
		//to be saved by the orderInterface
		return orderRepository.save(order);
	}

}
