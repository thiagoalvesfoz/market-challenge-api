package com.market.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.challenge.model.Category;
import com.market.challenge.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	private ResponseEntity<List<Category>> findAll() {
		List<Category> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{Id}")
	private ResponseEntity<Category> findById(@PathVariable Long Id) {
		Category obj = service.findById(Id);
		return ResponseEntity.ok(obj); //omitido o método body
	}
}
