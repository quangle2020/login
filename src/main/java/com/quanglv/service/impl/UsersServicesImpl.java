package com.quanglv.service.impl;

import com.quanglv.domain.Users;
import com.quanglv.repository.UsersRepository;
import com.quanglv.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServicesImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Override
    public Long saveUsers(Users user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return usersRepository.save(user).getUserId();
    }
}
