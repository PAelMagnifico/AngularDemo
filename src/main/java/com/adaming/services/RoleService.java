package com.adaming.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adaming.entities.Role;
import com.adaming.repositories.RoleRepositorie;

@Service
public class RoleService implements IRoleService{

	@Autowired
	RoleRepositorie roleRepositorie;
	
	@Override
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		return roleRepositorie.findAll();
	}

	@Override
	public Role findOne(Long id) {
		// TODO Auto-generated method stub
		Role role = roleRepositorie.findOne(id);
		return role;
	}

	@Override
	public Role save(Role role) {
		// TODO Auto-generated method stub
		return roleRepositorie.save(role);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		roleRepositorie.delete(id);
	}

}
