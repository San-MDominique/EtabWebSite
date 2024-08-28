package com.example.monwebetable.services;

import com.example.monwebetable.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);
    Optional<User> findOne(Long id);

    User upade(User user);

    List<User> findAll();

    void delete(Long id);
}
