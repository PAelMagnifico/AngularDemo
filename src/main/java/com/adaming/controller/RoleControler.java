package com.adaming.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Role;
import com.adaming.services.IRoleService;

@CrossOrigin("*")
@RestController
public class RoleControler {

	@Autowired
	IRoleService roleservice;
	
	@RequestMapping(value="roles", method=RequestMethod.GET)
	public List<Role> findAll(){
		return roleservice.findAll();
	}
	
	@RequestMapping(value = "roles/{id}", method = RequestMethod.GET)
	public Role findOne(@PathVariable("id") Long id) {
		return roleservice.findOne(id);
	}
	
	@RequestMapping(value = "roles", method = RequestMethod.POST)
	public Role saveRole(@RequestBody Role role) {
	
		return roleservice.save(role);
	}
	
	@RequestMapping(value = "roles/{id}", method = RequestMethod.DELETE)
	public void deleteRole(@PathVariable("id") Long id) {
		roleservice.delete(id);
	}
	
	@RequestMapping(value = "roles", method = RequestMethod.PUT)
	public Role updateUtilisateur(@PathVariable("id") Long id, @RequestBody Role role) {
		
		Role currentRole= roleservice.findOne(id);
		currentRole.setLibelle(role.getLibelle());
		
		return roleservice.save(currentRole);
}
}
