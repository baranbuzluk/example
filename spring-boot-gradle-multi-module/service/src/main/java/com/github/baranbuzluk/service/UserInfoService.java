package com.github.baranbuzluk.service;

import com.github.baranbuzluk.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    private final UserRepository userRepository;

    public UserInfoService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

}