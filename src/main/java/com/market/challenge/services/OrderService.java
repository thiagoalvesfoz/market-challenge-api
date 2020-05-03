package com.market.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.challenge.model.Order;
import com.market.challenge.repositories.OrderRepository;
import com.market.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository oRepository;
	
	public List<Order> findAll(){
		return oRepository.findAll();
	}
	

	public Order findById(Long orderId) {
		return oRepository.findById(orderId).orElseThrow(() -> new ResourceNotFoundException(orderId));
	}
}
