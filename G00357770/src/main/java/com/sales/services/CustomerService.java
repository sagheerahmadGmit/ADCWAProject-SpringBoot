package com.sales.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.models.Product;
import com.sales.repositories.CustomerRepository;
import com.sales.repositories.ProductRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	// this method gets all the Customers from the database
	public ArrayList<Customer> getCustomers() {
		return (ArrayList<Customer>) customerRepository.findAll();
	}
	
	//this method will save the new customer details
	public Customer save(Customer customer) {

		//Passes product object
		//to be saved by the productInterface
		return customerRepository.save(customer);
	}
}
