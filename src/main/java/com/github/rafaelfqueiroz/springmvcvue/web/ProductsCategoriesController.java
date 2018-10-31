package com.github.rafaelfqueiroz.springmvcvue.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.rafaelfqueiroz.springmvcvue.domain.ProductCategory;
import com.github.rafaelfqueiroz.springmvcvue.service.ProductCategoryService;

@Controller
@RequestMapping("/productsCategories")
public class ProductsCategoriesController {
	
	@Autowired
	private ProductCategoryService service;

	
	@GetMapping
	public ResponseEntity<List<ProductCategory>> getAll() {
		return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
	}
	
}
