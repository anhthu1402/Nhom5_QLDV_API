package com.qldv.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.dto.UserDto;
import com.qldv.api.model.Role;
import com.qldv.api.model.User;
import com.qldv.api.service.RoleService;
import com.qldv.api.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/users")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	RoleService roleService;
	
	//Create user
	@RequestMapping(value = "", method = RequestMethod.POST)
	public User createUser(@RequestBody User userDetail) {
		return userService.createUser(userDetail);
	}
	//get all user
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<UserDto> getAllUsers(){
		return userService.getAllUsers();
	}
	// get users by email
	@RequestMapping(value = "/{email}", method = RequestMethod.GET)
	public UserDto getAccountByNameOrEmail(@PathVariable(value = "email") String email) {
		return userService.getUsersByEmail(email);
	}
	//sign in by password and email
	@RequestMapping(value = "/signin/{email}/password/{password}", method = RequestMethod.POST)
	public UserDto signinUser(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
		return userService.signinUser(email, password);
	}
	
	//check password
	@RequestMapping(value = "/{email}/password/{password}", method = RequestMethod.POST)
	public boolean checkPassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
		return userService.checkPassword(email, password);
	}
	//update password 
	@RequestMapping(value = "/{email}/password/{password}", method = RequestMethod.PUT)
	public boolean updatePassword(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
		return userService.updatePassword(email, password);
	}
	//update user
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public UserDto updateUser(@PathVariable(value = "id") Integer id, @RequestBody User userDetail) {
		return userService.updateUser(id, userDetail);
	}
	//set role
	@RequestMapping(value = "/{id}/role", method = RequestMethod.PUT)
	public boolean setRole(@PathVariable(value = "id") Integer id, @RequestBody Role role) {
		return userService.setRole(id, role);
	}
}
