package com.qldv.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.dto.UserDto;
import com.qldv.api.model.Role;
import com.qldv.api.model.User;
import com.qldv.api.repository.RoleRepository;
import com.qldv.api.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	//Create user  not done
	public User createUser(User user) {
		Optional<Role> defaultRole = roleRepository.findById(1);
		Role role = defaultRole.get();
	    user.setRole(role);
	    return userRepository.save(user);
	}
	//get all user
	public List<UserDto> getAllUsers(){
		List<User> users = userRepository.findAll();
		List<UserDto> result = new ArrayList<UserDto>();
		for (User user : users) {
			result.add(new UserDto(user));				
		}
		return result;
	}
	// get users by email
	public UserDto getUsersByEmail(String email){
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) 
			return new UserDto(user.get());
		return null;
	}

	//sign in by password and email
	public UserDto signinUser(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		if (user.isPresent()) {
			if (user.get().getPassword().equals(password)) {
				return new UserDto(user.get());
			}
		}
		return null;
	}
	//check password
	public boolean checkPassword(String email, String password) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			User u = user.get();
			if (u.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}	
	//update password 
	public boolean updatePassword(String email, String newpassword) {
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent()) {
			User u = user.get();
			u.setPassword(newpassword);;
			userRepository.save(u);
			return true;
		}
		return false;
	}
	//update user
	public UserDto updateUser(Integer id, User userDetail) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User u = user.get();
			u.setName(userDetail.getName());
			u.setPhone(userDetail.getPhone());
			return new UserDto(userRepository.save(u));
		}
		return null;
	}
	//set role
	public boolean setRole(Integer id, Role role) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			User u = user.get();
			u.setRole(role);
			userRepository.save(u);
			return true;
		}
		return false;
	}
		
}
