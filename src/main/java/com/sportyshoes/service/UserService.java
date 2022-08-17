package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.model.User;

public interface UserService {

	User addUser(User user);

	User getUserById(Long id);

	void deleteUser(Long id);

	User updateUser(User user, Long id);

	List<User> getAllUser();

}
