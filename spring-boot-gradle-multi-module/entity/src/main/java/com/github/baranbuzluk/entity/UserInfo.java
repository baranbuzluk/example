package com.github.baranbuzluk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class UserInfo {
    @Id
    @GeneratedValue
    private Integer id;

    private String firstName;
    private String lastName;
}
