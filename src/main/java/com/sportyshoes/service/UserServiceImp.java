package com.sportyshoes.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.model.User;
import com.sportyshoes.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository uRepository;

	@Override
	public User addUser(User user) {
		return uRepository.save(user);
	}

	@Override
	public User getUserById(Long id) {
		return uRepository.findById(id).get();
	}

	@Override
	public void deleteUser(Long id) {
		uRepository.deleteById(id);
	}

	@Override
	public User updateUser(User user, Long id) {
		User oldUser = uRepository.findById(id).get();
		if (Objects.nonNull(user.getUsreName())) {
			oldUser.setUsreName(user.getUsreName());
		}
		if (Objects.nonNull(user.getEmail())) {
			oldUser.setEmail(user.getEmail());
		}
		return uRepository.save(oldUser);
	}

	@Override
	public List<User> getAllUser() {
		return uRepository.findAll();
	}

}
