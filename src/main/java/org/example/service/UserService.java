package org.example.service;

import java.util.List;

import org.example.domain.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository USER_REPOSITORY;

	public List<User> findAll() {
		return USER_REPOSITORY.findAll();
	}

}
