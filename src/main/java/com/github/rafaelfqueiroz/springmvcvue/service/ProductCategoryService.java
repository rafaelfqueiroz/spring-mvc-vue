package com.github.rafaelfqueiroz.springmvcvue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.rafaelfqueiroz.springmvcvue.domain.ProductCategory;
import com.github.rafaelfqueiroz.springmvcvue.repository.ProductCategoryRepository;

@Service
public class ProductCategoryService {
	
	@Autowired
	private ProductCategoryRepository categoryRepository;

	public List<ProductCategory> getAll() {
		return categoryRepository.findAll(Sort.by("name"));
	}
}
