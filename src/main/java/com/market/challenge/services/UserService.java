package com.market.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.market.challenge.model.User;
import com.market.challenge.repositories.UserRepository;
import com.market.challenge.services.exceptions.DatabaseException;
import com.market.challenge.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}

	public User findById(Long userId) {
		return repository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
	}
	
	public User insert(User user) {
		return repository.save(user);
	}
	
	public void delete(Long id) {
		try {
			User user = this.findById(id);
			repository.deleteById(user.getId());
		} 
		catch(DataIntegrityViolationException ex) {
			throw new DatabaseException(ex.getMessage());
		}
	}
	
	public User update(Long userId, User body) {
		User entity = this.findById(userId);
		updateData(entity, body);
		return repository.save(entity);
	}

	private void updateData(User entity, User body) {
		entity.setName(body.getName());
		entity.setEmail(body.getEmail());
		entity.setPhone(body.getPhone());
	}
}
