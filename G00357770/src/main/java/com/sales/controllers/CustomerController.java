package com.sales.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.services.CustomerService;
import com.sales.services.ProductService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	// display customers
	@RequestMapping(value = "/showCustomers", method = RequestMethod.GET)
	public String getCustomers(Model m) {

		ArrayList<Customer> customers = (ArrayList<Customer>) customerService.getCustomers();

		m.addAttribute("customers", customers);

		return "showCustomers";
	}
	
	//add Customer
	// this is the get request which directs to the add customer page
	@RequestMapping(value = "/addCustomer", method = RequestMethod.GET)
	public String getAddCustomer(@ModelAttribute("customer") Customer customer, HttpServletRequest h) {

		return "addCustomer";
	}
	
	// This is the post request which saves the customer object 
	// then displays the new data on the display page 
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer") Customer customer,BindingResult result) {

		if(result.hasFieldErrors()) {			
			return "addCustomer";
		}else{
			// Pass the product to the product Service for saving
			customerService.save(customer);
			return "redirect:showCustomers";
		}
		
	}
	
}
