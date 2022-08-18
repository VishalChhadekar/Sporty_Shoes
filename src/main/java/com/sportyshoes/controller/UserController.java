package com.sportyshoes.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.exceptions.UserNotFoundException;
import com.sportyshoes.model.User;
import com.sportyshoes.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	// ADD USER
	@PostMapping("/singup")
	public User addUser(@RequestBody User user) throws Exception {
		return userService.addUser(user);
	}

	// FIND USER BY ID
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception {
		User user = userService.getUserById(id);
		if (Objects.isNull(user)) {
			throw new UserNotFoundException("User is not pressent with this id");
		}
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// DELETE USER
	@DeleteMapping("/{id}")
	public String deleteUser(@PathVariable Long id) throws Exception {
		userService.deleteUser(id);
		return "User deleted successfull";
	}

	// UPDATE USER
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
		return userService.updateUser(user, id);
	}

}
