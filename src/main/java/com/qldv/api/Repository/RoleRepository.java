package com.qldv.api.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qldv.api.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	Optional<Role> findByType(String type);
}
