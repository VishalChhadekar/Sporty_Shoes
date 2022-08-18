package com.sportyshoes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.CustomUserDetails;
import com.sportyshoes.model.AppUserModel;
import com.sportyshoes.entity.AppUser;
import com.sportyshoes.repository.CustomeUserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomeUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		AppUser user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(user);
	}

	public void adminSingUp(AppUserModel appUserModel) {
		// first delete old Admin's old credentials
		userRepository.deleteByUsername(appUserModel.getOldUserName());

		// then add new credentials
		AppUser appUser = new AppUser();
		appUser.setId(appUserModel.getId());
		appUser.setUsername(appUserModel.getUsername());
		appUser.setRole(appUserModel.getRole());
		appUser.setPassword(appUserModel.getPassword());
		userRepository.save(appUser);

	}

	public AppUser updatePassword(AppUserModel appUserModel, Long id) {
		AppUser appUser = userRepository.findById(id).get();
		appUser.setPassword(appUserModel.getPassword());
		return userRepository.save(appUser);
	}
}
