package com.market.challenge.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.market.challenge.model.User;
import com.market.challenge.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api("User")
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation("Mostra lista de usuários")
	@GetMapping
	private ResponseEntity<List<User>> findAll() {
		List<User> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@ApiOperation("Mostra dados do usuário cadastrado")
	@GetMapping("/{userId}")
	private ResponseEntity<User> findById(@PathVariable Long userId) {
		User obj = service.findById(userId);
		return ResponseEntity.ok(obj); //omitido o método body
	}
	
	@ApiOperation("Adiciona um novo usuário")
	@PostMapping 	//inserindo de forma adequada
	private ResponseEntity<User> insert(@RequestBody User user) {
		
		user = service.insert(user);
		
		//mais um avanço no REST.
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(user.getId())
				.toUri();
				
		return ResponseEntity.created(uri).body(user);
	}
	
	@ApiOperation("Deleta um usuário cadastrado pelo id")
	@DeleteMapping("/{id}")
	private ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Atualiza dados do usuário")
	@PutMapping("/{id}")
	private ResponseEntity<User> update(@PathVariable Long id, @RequestBody User userBody){
		userBody = service.update(id, userBody);
		return ResponseEntity.ok().body(userBody);
	}
	
}
