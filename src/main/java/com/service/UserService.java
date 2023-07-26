package com.service;

import com.response.UserDTO;

public interface UserService {

	UserDTO createUser(UserDTO userDTO);

	UserDTO getUserById(Integer userId);

	UserDTO getUserByEmail(String email);

}
