package com.github.rafaelfqueiroz.springmvcvue.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.rafaelfqueiroz.springmvcvue.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
