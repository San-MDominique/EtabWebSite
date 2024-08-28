package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Student;
import com.example.monwebetable.repositories.StudentRepository;
import com.example.monwebetable.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> findOne(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student update(Student student) {
        if (student.getId() == null) {
            throw new IllegalArgumentException("l'id de létudiant est null");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }


    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);

    }
}