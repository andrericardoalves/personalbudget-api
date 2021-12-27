package com.alves.personalbudget.service;

import com.alves.personalbudget.model.User;
import com.alves.personalbudget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public Optional<User> findByEmail(String email){
        return repository.findByEmail(email);
    }
}
