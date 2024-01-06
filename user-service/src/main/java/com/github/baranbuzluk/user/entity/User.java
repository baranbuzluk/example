package com.github.baranbuzluk.user.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

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

	public void setUpdatedAt(LocalDateTime updatedAt) {
		throw new UnsupportedOperationException(
				"When the entity is saved in the database, updatedAt will already be updated!");
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		throw new UnsupportedOperationException(
				"When the entity is saved in the database, createdAt will be assigned the current time");
	}

	@PrePersist
	private void whenSaving() {
		createdAt = LocalDateTime.now();
		updatedAt = createdAt;
	}

	@PreUpdate
	private void whenUpdating() {
		updatedAt = LocalDateTime.now();
	}
}
