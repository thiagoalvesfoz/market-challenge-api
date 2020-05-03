package com.market.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.challenge.model.Product;
import com.market.challenge.repositories.ProductRepository;
import com.market.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	

	public Product findById(Long productId) {
		return repository.findById(productId).orElseThrow(() -> new ResourceNotFoundException(productId));
	}
}
