package com.github.rafaelfqueiroz.springmvcvue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.rafaelfqueiroz.springmvcvue.domain.Product;
import com.github.rafaelfqueiroz.springmvcvue.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;

	public Product save(Product product) {
		return repository.save(product);
	}
	
	public List<Product> getAll() {
		return repository.findAll(Sort.by("name"));
	}
}
