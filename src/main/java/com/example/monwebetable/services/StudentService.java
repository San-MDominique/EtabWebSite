package com.example.monwebetable.services;

import com.example.monwebetable.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Student save(Student student);
    Optional<Student> findOne(Long id);

    Student update(Student student);

     List<Student>findAll();
    void delete(Long id);
}
