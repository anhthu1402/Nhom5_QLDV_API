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
import org.springframework.web.bind.annotation.RestController;

import com.qldv.api.Exception.NotFoundException;
import com.qldv.api.Model.Role;
import com.qldv.api.Service.Implement.RoleService;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/roles")
public class RoleController {
		@Autowired
		RoleService roleService;
	
		//create role
		@RequestMapping(value = "", method = RequestMethod.POST)
		public ResponseEntity<Role> createRole(@RequestBody Role roleDetail) {
			Role role = roleService.createRole(roleDetail);
			return new ResponseEntity<>(role, HttpStatus.CREATED);
		}
		
		//get all roles
		@RequestMapping(value = "", method = RequestMethod.GET)
		public ResponseEntity<List<Role>> getAllRoles(){
			  List<Role> roles = roleService.getAllRoles();
		      return new ResponseEntity<>(roles, HttpStatus.OK);
		}
		
		//get role by id
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public ResponseEntity<Role> getRoleById(@PathVariable(value = "id") Integer id) {
			Role role = roleService.getRoleById(id);
			 if(role == null){
		            throw new NotFoundException("Không tìm thấy role có id là: " + id);
		        }
			return new ResponseEntity<>(role, HttpStatus.OK);
		}
		
		//update role
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public ResponseEntity<Role> updateRole(@PathVariable(value = "id") Integer id, @RequestBody Role roleDetail) {
			try {
				Role role = roleService.updateRole(id, roleDetail);
				return new ResponseEntity<>(role, HttpStatus.OK);
			}catch(Exception e) {
				throw new NotFoundException("Không tìm thấy role có id là: " + id);
			}
		}
		
}
