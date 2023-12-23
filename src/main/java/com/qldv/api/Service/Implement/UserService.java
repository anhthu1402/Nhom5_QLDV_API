package com.qldv.api.Service.Implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.DTO.UserDto;
import com.qldv.api.Model.LoginForm;
import com.qldv.api.Model.Role;
import com.qldv.api.Model.User;
import com.qldv.api.Repository.RoleRepository;
import com.qldv.api.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	//Create user 
	public UserDto createUser(User user) {
		List<User> users = userRepository.findAll();
		for (User user2 : users) {
			if(user2.getEmail().equals(user.getEmail())) {
				return null;
			}
		}
		Optional<Role> role = roleRepository.findByType("Người dùng");
		if(role.isPresent()) {
			Role r = role.get();
			user.setRole(r);
			userRepository.save(user);
			return new UserDto(user);
		}
	    return null;
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

	
	//sign in
	public UserDto signIn(LoginForm loginForm, Integer role) {
		Optional<User> user = userRepository.findByEmail(loginForm.getEmail());
		if (user.isPresent()) {
			if (user.get().getPassword().equals(loginForm.getPassword())) {
				if(role == null) {
					if(user.get().getRole().getId()== 1) {
						return new UserDto(user.get());
					}
				}else {
					if(user.get().getRole().getId() != 1) {
						return new UserDto(user.get());
					}
				}
			}
		}
		return null;
	}
	
	
	//check password
	public boolean checkPassword(LoginForm loginForm) {
		Optional<User> user = userRepository.findByEmail(loginForm.getEmail());
		if(user.isPresent()) {
			User u = user.get();
			if (u.getPassword().equals(loginForm.getPassword())) {
				return true;
			}
		}
		return false;
	}	
	//update password 
	public boolean updatePassword(LoginForm updateForm) {
		Optional<User> user = userRepository.findByEmail(updateForm.getEmail());
		if(user.isPresent()) {
			User u = user.get();
			u.setPassword(updateForm.getPassword());;
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
	public boolean setRole(Integer id, Integer idRole) {
		Optional<User> user = userRepository.findById(id);
		Role role = roleRepository.findById(idRole).get();
		if(user.isPresent()) {
			User u = user.get();
			u.setRole(role);
			userRepository.save(u);
			return true;
		}
		return false;
	}
		
}
