package com.sportyshoes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.AppUser;
import com.sportyshoes.model.AppUserModel;
import com.sportyshoes.service.CustomUserDetailsService;

@RestController
@RequestMapping("/admin")
public class AdminCredentialController {

	@Autowired
	private CustomUserDetailsService cdS;

	// ADD ADMIN
	@PostMapping("singup")
	public String singUp(@RequestBody AppUserModel appUserModel) throws Exception {
		cdS.adminSingUp(appUserModel);
		return "SingUp successfull!";
	}

	// UPDATE PASSWORD
	@PutMapping("/updatePassword/{id}")
	public AppUser updatePassword(@RequestBody AppUserModel appUserModel, @PathVariable Long id) throws Exception {
		return cdS.updatePassword(appUserModel, id);
	}

}
