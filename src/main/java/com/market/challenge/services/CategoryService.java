package com.market.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.challenge.model.Category;
import com.market.challenge.repositories.CategoryRepository;
import com.market.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepository;
	
	public List<Category> findAll(){
		return catRepository.findAll();
	}
	

	public Category findById(Long categoryId) {
		return catRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException(categoryId));
	}
}
