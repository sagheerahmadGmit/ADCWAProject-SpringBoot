package com.sales.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Order;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.OrderService;
import com.sales.services.ProductService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;

	// display Orders
	@RequestMapping(value = "/showOrders", method = RequestMethod.GET)
	public String getOrders(Model m) {

		ArrayList<Order> orders = (ArrayList<Order>) orderService.getOrders();

		m.addAttribute("orders", orders);

		return "showOrders";
	}
	
	//handles roll back exceptions 
	@ExceptionHandler(value = RollbackException.class)
	public String handleErr() {
		
		return "Error";
		
	}
	
	//handles null pointers 
	@ExceptionHandler(value = NullPointerException.class)
	public String handleError() {

		return "ErrorPageForOrder";
	}
}
