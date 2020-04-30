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
		// save the data to the array list
		ArrayList<Order> orders = (ArrayList<Order>) orderService.getOrders();
		// add the attributes to the model
		m.addAttribute("orders", orders);
		// return the show orders page
		return "showOrders";
	}

	// this is the get request which directs to the add order page
	@RequestMapping(value = "/addOrder", method = RequestMethod.GET)
	public String getAddOrderCust(Model m) {

		// Get customer from DB
		ArrayList<Customer> customers = (ArrayList<Customer>) customerService.getCustomers();
		// Create custList Map
		Map<Long, String> custList = new HashMap<Long, String>();
		// Add customer to Map
		for (Customer c : customers) {
			custList.put(c.getcId(), c.getcName());
		}

		// add the attribute to the model
		m.addAttribute("custList", custList);

		// Get products from DB
		ArrayList<Product> products = (ArrayList<Product>) productService.getProducts();
		// Create prodList Map
		Map<Long, String> prodList = new HashMap<Long, String>();
		// Add products to Map
		for (Product p : products) {
			prodList.put(p.getpId(), p.getpDesc());
		}
		// Add prodList to Model
		m.addAttribute("prodList", prodList);
		// create a new order instance and add the order to the model
		Order order = new Order();
		m.addAttribute("order", order);

		// return the add order page
		return "addOrder";
	}

	// This is the post request which saves the order object
	// then displays the new data on the display page
	@RequestMapping(value = "/addOrder", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("order") Order order, BindingResult result) {
		
		//if it has errors then reload the page
		if (result.hasFieldErrors()) {
			return "addOrder";
		} else {
			// Pass the product to the product Service for saving
			//redirect the user to the show orders page
			orderService.save(order);
			return "redirect:showOrders";
		}
	}

}
