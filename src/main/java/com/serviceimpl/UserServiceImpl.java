package com.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.ResourceNotFoundException;
import com.repository.UserRepo;
import com.response.UserDTO;
import com.service.UserService;
import com.util.EmailUtil;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		User savedUser = this.userRepo.save(dtoToUser(userDTO));
		try {
			EmailUtil.sendEmail(savedUser);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return this.userToDTO(savedUser);
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId.toString()));
		return this.userToDTO(user);
	}

	@Override
	public UserDTO getUserByEmail(String email) {
		User user = this.userRepo.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Email", email));
		return this.userToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepo.findAll();
		List<UserDTO> userDTOs = users.stream().map(this::userToDTO).collect(Collectors.toList());
		return userDTOs;
	}

	public User dtoToUser(UserDTO userDTO) {
		User user = new User();
		user.setId(userDTO.getId());
		user.setName(userDTO.getName());
		user.setEmail(userDTO.getEmail());
		user.setDob(userDTO.getDob());
		user.setPhoneNo(userDTO.getPhoneNo());
		return user;
	}

	public UserDTO userToDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setName(user.getName());
		userDTO.setEmail(user.getEmail());
		userDTO.setDob(user.getDob());
		userDTO.setPhoneNo(user.getPhoneNo());
		return userDTO;
	}
}
