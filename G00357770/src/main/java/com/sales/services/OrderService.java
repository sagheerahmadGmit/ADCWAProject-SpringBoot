package com.sales.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	
	//format the date
	private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	//get the current date
	private Date date = new Date();

	// this method gets all the Orders from the database
	public ArrayList<Order> getOrders() {
		//get all the orders in the database using the order repository and save to an arraylist
		return (ArrayList<Order>) orderRepository.findAll();
	}
	
	//this method will save the new order details
	public Order save(Order order) {
		//set the date of the order to the current date
		order.setOrderDate(df.format(date));
		//Passes order object
		//to be saved by the orderInterface to the database
		return orderRepository.save(order);
	}

}
