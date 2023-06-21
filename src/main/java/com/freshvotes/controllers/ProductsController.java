package com.freshvotes.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.freshvotes.domain.Product;
import com.freshvotes.domain.User;
import com.freshvotes.repository.ProductRepo;

@Controller
public class ProductsController {

	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductRepo productRepo;
	
	@GetMapping("/products")
	public String  getProducts(ModelMap model, @AuthenticationPrincipal User user) {
		
		List<Product> products = productRepo.findByUser(user);
		model.put("products", products);
		return "products";
	}
	
	@GetMapping("/products/{productId}")
	public String getProduct(@PathVariable Long productId, ModelMap model, HttpServletResponse response) throws IOException {
		Optional<Product> productOpt = productRepo.findById(productId);
		
		if(productOpt.isPresent()) {
			  Product product = productOpt.get();
			  model.put("product", product);
			  return "product";
		}else {
			response.sendError(HttpStatus.NOT_FOUND.value() , "product is not found");
			return "product";
		} 
			 
	}
	
	
	@GetMapping("/p/{productName}")
	public String getProductUserView(@PathVariable String productName, ModelMap model) {
		if(productName != null) {
			try {
				String name = URLDecoder.decode(productName, StandardCharsets.UTF_8.name());
				Optional<Product> productOpt = productRepo.findByName(name);
					if(productOpt.isPresent()) {
						model.put("product", productOpt.get());
					}
			} catch (UnsupportedEncodingException e) {
				log.error("Error while decoding... /n", e);
			}
		}
				
		return "productUserView";
	}
	
	
	@PostMapping("/products")
	public String createProduct(@AuthenticationPrincipal User user) {
		Product product = new Product();
		
		product.setPublished(false);
		product.setUser(user);
		
		product = productRepo.save(product);
		
		return "redirect:/products/" + product.getId();
	}
	
	@PostMapping("/products/{productId}")
	public String saveProduct(@PathVariable Long productId, Product product) {
		productRepo.save(product);
		return "redirect:/products/" + product.getId();
	}
	
	
}
