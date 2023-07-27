package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.response.Status;
import com.response.UserDTO;
import com.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/userinfo")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Status createUser(@Valid @RequestBody UserDTO userDTO) {
		userService.createUser(userDTO);
		return new Status("User Created Successfully", 201);
	}

	@GetMapping("id/{userId}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getUserById(@PathVariable Integer userId) {
		return this.userService.getUserById(userId);
	}

	@GetMapping("email/{email}")
	@ResponseStatus(HttpStatus.OK)
	public UserDTO getUserByEmail(@PathVariable String email) {
		return this.userService.getUserByEmail(email);
	}

}
