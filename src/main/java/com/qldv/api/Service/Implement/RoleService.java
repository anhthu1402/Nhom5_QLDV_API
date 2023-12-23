package com.qldv.api.Service.Implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qldv.api.Model.Role;
import com.qldv.api.Model.User;
import com.qldv.api.Repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	//create role
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}
	
	//get all role
	public List<Role> getAllRoles(){
		return roleRepository.findAll();
	}
	
	//get role by id
	public Role getRoleById(Integer id) {
		Optional<Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			return role.get();
		}
		return new Role();
	}
	
	//update role
	public Role updateRole(Integer id, Role roleDetail) {
		Optional<Role> role = roleRepository.findById(id);
		if(role.isPresent()) {
			Role r = role.get();
			r.setType(roleDetail.getType());
			return roleRepository.save(r);
		}
		return roleRepository.save(roleDetail);
	}
	

}
