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

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	// display products
	@RequestMapping(value = "/showProducts", method = RequestMethod.GET)
	public String getProducts(Model m) {

		ArrayList<Product> products = (ArrayList<Product>) productService.getProducts();

		m.addAttribute("products", products);

		return "showProducts";
	}
	
	//add Product
	// this is the get request which directs to the add product page
	@RequestMapping(value = "/addProducts", method = RequestMethod.GET)
	public String getAddProducts(@ModelAttribute("product") Product product, HttpServletRequest h) {

		return "addProducts";
	}

	// This is the post request which saves the product object 
	// then displays the new data on the display page 
	@RequestMapping(value = "/addProducts", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("product") Product product,BindingResult result) {

		if(result.hasFieldErrors()) {			
			return "addProducts";
		}else{
			// Pass the product to the product Service for saving
			productService.save(product);
			return "redirect:showProducts";
		}
		
	}
}