package org.example.controller;


import java.util.List;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.config.*;;


@RestController
@RequestMapping("/api")
public class UserController {
 

	@Autowired
	UserRepository  USER_REPOSITORY ;

	@GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User>  list() {
		return USER_REPOSITORY.findAll();
	}
	
	
	@GetMapping("/user/{id}")
	User getUser(@PathVariable Long id) {
		User user = USER_REPOSITORY.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
		return user;
	}
	
	@PostMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public User save(@RequestBody User newUser) {
		return USER_REPOSITORY.save(newUser);
	}

	@PutMapping("/user/{id}")
	User replaceEmployee(@RequestBody User newUser, @PathVariable Long id) {

		User user = USER_REPOSITORY.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));

		user.setFirstname(newUser.getFirstname());
		user.setLastname(newUser.getLastname());
		return user;
	
	}

	@DeleteMapping("/user/{id}")
	void deleteEmployee(@PathVariable Long id) {
		USER_REPOSITORY.deleteById(id);
	}
 
	
 
}