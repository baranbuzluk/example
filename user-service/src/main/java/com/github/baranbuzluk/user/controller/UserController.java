package com.github.baranbuzluk.user.controller;

import com.github.baranbuzluk.user.dto.UserDto;
import com.github.baranbuzluk.user.entity.User;
import com.github.baranbuzluk.user.mapper.UserMapper;
import com.github.baranbuzluk.user.service.UserService;
import com.github.baranbuzluk.user.util.UpdateHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/{id}")
	public Optional<User> findUser(@PathVariable Integer id) {
		return userService.find(id);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<User> patchUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
		Optional<User> userInDb = userService.find(id);
		if (userInDb.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		User desiredUser = UserMapper.INSTANCE.toEntity(userDto);
		User existingUser = userInDb.get();
		new UpdateHelper<>(existingUser, desiredUser).update();
		return ResponseEntity.ok(userService.saveUser(existingUser));
	}

	@GetMapping
	public List<User> findAllUsers() {
		return userService.findAll();
	}

	@PostMapping
	public User addUser(@RequestBody UserDto user) {
		return userService.saveUser(UserMapper.INSTANCE.toEntity(user));
	}

	@DeleteMapping
	public void deleteAllUsers() {
		userService.deleteAllUsers();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}

}
