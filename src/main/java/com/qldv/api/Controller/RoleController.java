package com.qldv.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
		public Role createRole(@RequestBody Role roleDetail) {
			return roleService.createRole(roleDetail);
		}
		
		//get all roles
		@RequestMapping(value = "", method = RequestMethod.GET)
		public List<Role> getAllRoles(){
			return roleService.getAllRoles();
		}
		
		//get role by id
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public Role getRoleById(@PathVariable(value = "id") Integer id) {
			return roleService.getRoleById(id);
		}
		
		//update role
		@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
		public Role updateRole(@PathVariable(value = "id") Integer id, @RequestBody Role roleDetail) {
			return roleService.updateRole(id, roleDetail);
		}
		
}
