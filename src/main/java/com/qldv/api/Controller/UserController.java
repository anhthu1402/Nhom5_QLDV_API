package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.DTO.UserDto;
import com.qldv.api.Exception.CustomValidationException;
import com.qldv.api.Exception.NotFoundException;
import com.qldv.api.Exception.UnauthorizedException;
import com.qldv.api.Model.LoginForm;
import com.qldv.api.Model.User;
import com.qldv.api.Service.Implement.RoleService;
import com.qldv.api.Service.Implement.UserService;

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
	public ResponseEntity<UserDto> createUser(@RequestBody User userDetail) {
        try {
            UserDto createdUser = userService.createUser(userDetail);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        }catch (Exception e) {
        	throw new UnauthorizedException("Email: " + userDetail.getEmail() + " đã tồn tại trong hệ thống.");
        }
//        if(createdUser == null) {
//			throw new ("Email: " + userDetail.getEmail() + " đã tồn tại trong hệ thống.");
//		}
//	    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);    
	}
	//get all user
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> users = userService.getAllUsers();
	    return new ResponseEntity<>(users, HttpStatus.OK);
	}
	// get users by email
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUserByEmail(@PathVariable(value = "email") String email) {
		UserDto user = userService.getUsersByEmail(email);
		if(user == null){
            throw new NotFoundException("Không tìm thấy người dùng có email là: " + email);
        }
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	// get users by id
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDto> getUserById(@PathVariable(value = "id") Integer id) {
		UserDto user = userService.getUsersById(id);
		if(user == null) {
			throw new NotFoundException("Không tìm thấy người dùng có id là: " + id);
		}
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}

	//sign in for roles
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ResponseEntity<?> signIn(@RequestBody LoginForm loginForm, @RequestParam(value = "role", required = false) Integer role) {
		 try {
		        UserDto userDto = userService.signIn(loginForm, role);
		        return ResponseEntity.ok(userDto);
		    } catch (CustomValidationException | NotFoundException | UnauthorizedException ex) {
		        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
		    } catch (Exception ex) {
		        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi không xác định");
		    }
	}
	
	//admin
	@RequestMapping(value = "/signin2", method = RequestMethod.POST)
	public UserDto signIn2(@RequestBody LoginForm loginForm, @RequestParam(value = "role", required = false) Integer role) {
		return userService.signIn2(loginForm, role);
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
	public ResponseEntity<UserDto> updateUser(@PathVariable(value = "id") Integer id, @RequestBody User userDetail) {
		UserDto user = userService.updateUser(id, userDetail);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	//set role
	@RequestMapping(value = "/{id}/role/{role_id}", method = RequestMethod.PUT)
	public boolean setRole(@PathVariable(value = "id") Integer id, @PathVariable(value = "role_id") Integer role_id) {
		return userService.setRole(id, role_id);
	}
}
