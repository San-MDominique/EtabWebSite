package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.User;
import com.example.monwebetable.repositories.UserRepository;
import com.example.monwebetable.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository  userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User upade(User user) {
        return userRepository.save(user);

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public void delete(Long id) {
        // Vérification de l'existence de l'utilisateur
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("Utilisateur avec l'ID " + id + " non trouvé.");
        }
        // Suppression de l'utilisateur
        userRepository.deleteById(id);
    }

}

