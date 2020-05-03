package com.market.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.challenge.model.Order;
import com.market.challenge.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
	
	@Autowired
	private OrderService oService;
	
	@GetMapping
	private ResponseEntity<List<Order>> findAll() {
		List<Order> list = oService.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{orderId}")
	private ResponseEntity<Order> findById(@PathVariable Long orderId) {
		Order obj = oService.findById(orderId);
		return ResponseEntity.ok(obj); //omitido o método body
	}
}
