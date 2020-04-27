package com.sales.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sales.models.Product;
import com.sales.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// this method gets all the products from the database
	public ArrayList<Product> getProducts() {
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	//this method will save the new product details
	public Product save(Product product) {

		//Passes product object
		//to be saved by the productInterface
		return productRepository.save(product);
	}

}
