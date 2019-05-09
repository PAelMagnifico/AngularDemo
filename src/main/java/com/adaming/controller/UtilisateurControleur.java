package com.adaming.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adaming.entities.Utilisateur;
import com.adaming.services.IUtilisateurService;

@CrossOrigin("*")
@RestController
public class UtilisateurControleur {

	@Autowired
	IUtilisateurService utilisateurService;
	

	@RequestMapping(value="users", method=RequestMethod.GET)
	public List<Utilisateur> findAll(){
		return utilisateurService.findAll();
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.GET)
	public Utilisateur findOne(@PathVariable("id") Long id) {
		return utilisateurService.findOne(id);
	}
	
	@RequestMapping(value = "users", method = RequestMethod.POST)
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
	
		return utilisateurService.save(utilisateur);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
	public void deleteUtilisateur(@PathVariable("id") Long id) {
		utilisateurService.delete(id);
	}
	
	@RequestMapping(value = "users/{id}", method = RequestMethod.PUT)
	public Utilisateur updateUtilisateur(@PathVariable("id") Long id, @RequestBody Utilisateur utilisateur) {
		
		Utilisateur currentUser= utilisateurService.findOne(id);
		currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		
		return utilisateurService.save(currentUser);
}
}
