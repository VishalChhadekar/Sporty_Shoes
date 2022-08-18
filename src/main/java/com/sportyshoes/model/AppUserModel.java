package com.sportyshoes.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUserModel {

	private Long id;
	private String username;
	private String password;
	private String role;
	private String oldUserName;
}
