package com.github.baranbuzluk;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.baranbuzluk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
