package com.github.baranbuzluk.user.dto;

import lombok.Data;

@Data
public class CreateUser {
	private String password;
	private String email;
	private String username;
}
