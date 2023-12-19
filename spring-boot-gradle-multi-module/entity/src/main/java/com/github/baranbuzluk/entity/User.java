package com.github.baranbuzluk.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {
  private String firstName;
  private String lastName;
}
