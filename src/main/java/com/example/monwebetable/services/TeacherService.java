package com.example.monwebetable.services;

import com.example.monwebetable.models.Teacher;

import java.util.List;
import java.util.Optional;

public interface TeacherService {
    Teacher save(Teacher teacher);
    Optional<Teacher> findOne(Long id);
    Teacher update(Teacher teacher);  // Correction du nom de la méthode

    List<Teacher> findAll();
    // Suppression de la méthode statique

    void delete(Long id);
}
