package com.github.baranbuzluk.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "users")
public class User {

	@Id
	@GeneratedValue
	private Integer id;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime updatedAt;

	private String username;
	private String password;
	private String email;

	public User() {
		createdAt = LocalDateTime.now();
		updatedAt = createdAt;
	}
}
