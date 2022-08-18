package com.sportyshoes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.AppUser;

@Repository
public interface CustomeUserRepository extends JpaRepository<AppUser, Long> {

	AppUser findByUsername(String username);

	@Transactional
	void deleteByUsername(String oldUserName);
}
