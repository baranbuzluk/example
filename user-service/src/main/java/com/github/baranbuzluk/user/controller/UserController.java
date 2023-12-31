package com.github.baranbuzluk.user.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.github.baranbuzluk.user.dto.CreateUser;
import com.github.baranbuzluk.user.entity.User;
import com.github.baranbuzluk.user.mapper.UserMapper;
import com.github.baranbuzluk.user.service.UserService;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public User findUser(@PathVariable Integer id) {
		return userService.findById(id);
	}

	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@PostMapping
	public User addUser(@RequestBody CreateUser user) {
		return userService.addUser(UserMapper.INSTANCE.toEntity(user));
	}

}
