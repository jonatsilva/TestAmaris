package com.cl.sodexo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cl.sodexo.model.User;
import com.cl.sodexo.repository.UserRepository;

/**
 * The Class UserService.
 */
@Component
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User createuser(User user) {
		return userRepository.save(user);
	}

	public boolean getUserByEmail(String email) {
		return userRepository.findByEmail(email);

	}

}
