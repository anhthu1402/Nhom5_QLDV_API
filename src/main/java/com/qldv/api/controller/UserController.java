package com.qldv.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.dto.UserDto;
import com.qldv.api.model.LoginForm;
import com.qldv.api.model.Role;
import com.qldv.api.model.User;
import com.qldv.api.service.Implement.RoleService;
import com.qldv.api.service.Implement.UserService;

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
	public UserDto createUser(@RequestBody User userDetail) {
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
	//sign in for user
	@RequestMapping(value = "/signin-user", method = RequestMethod.POST)
	public UserDto signinUser(@RequestBody LoginForm loginForm) {
		return userService.signinUser(loginForm);
	}
	//sign in admin
	@RequestMapping(value = "/signin-admin", method = RequestMethod.POST)
	public UserDto signinAdmin(@RequestBody LoginForm loginForm) {
		return userService.signinAdmin(loginForm);
	}
	//sign in for roles
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public UserDto signIn(@RequestBody LoginForm loginForm, @RequestParam(value = "role", required = false) Integer roleId) {
		return userService.signIn(loginForm, roleId);
	}
	
	//check password
	@RequestMapping(value = "/check-password", method = RequestMethod.POST)
	public boolean checkPassword(@RequestBody LoginForm loginForm) {
		return userService.checkPassword(loginForm);
	}
	//update password 
	@RequestMapping(value = "/update-password", method = RequestMethod.PUT)
	public boolean updatePassword(@RequestBody LoginForm updateForm) {
		return userService.updatePassword(updateForm);
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
