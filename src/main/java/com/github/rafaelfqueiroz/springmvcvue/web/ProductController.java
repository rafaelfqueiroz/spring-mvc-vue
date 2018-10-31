package com.github.rafaelfqueiroz.springmvcvue.web;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.rafaelfqueiroz.springmvcvue.domain.Product;
import com.github.rafaelfqueiroz.springmvcvue.service.ProductService;


@Controller
@RequestMapping("/products")
public class ProductController {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/index")	public String form() { return "products/form"; }
	
	
	

	@PostMapping
	public ResponseEntity<Product> save(@RequestBody @Valid Product product, BindingResult br) {
		
		if (br.hasErrors()) {
			logger.debug("PRODUCT SUBMITED WITH ERRORS");
		}
		
		Product persistedProduct = service.save(product);
	
		return new ResponseEntity<>(persistedProduct, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
}
