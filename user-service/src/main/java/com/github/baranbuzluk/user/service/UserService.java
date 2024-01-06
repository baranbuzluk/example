package com.github.baranbuzluk.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.baranbuzluk.user.entity.User;
import com.github.baranbuzluk.user.repository.UserRepository;

@Service
public class UserService {
	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> find(Integer id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}
}
