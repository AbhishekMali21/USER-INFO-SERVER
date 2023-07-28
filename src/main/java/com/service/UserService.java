package com.service;

import java.util.List;

import com.response.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO getUserById(Integer userId);

	List<UserDTO> getAllUsers();

	UserDTO getUserByEmail(String email);

}
