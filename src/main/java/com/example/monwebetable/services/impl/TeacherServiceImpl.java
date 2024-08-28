package com.example.monwebetable.services.impl;

import com.example.monwebetable.models.Teacher;
import com.example.monwebetable.repositories.TeacherRepository;
import com.example.monwebetable.services.TeacherService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;


    @Override
    public Teacher save(Teacher teacher) {
        return teacherRepository.save(teacher);

    }

    @Override
    public Optional<Teacher> findOne(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Teacher update(Teacher teacher) {
        if (teacher.getId() == null) {
            throw new IllegalArgumentException("L'ID de l'enseignant ne peut pas être nul.");
        }

        // Trouver l'enseignant existant par ID
        Teacher existingTeacher = teacherRepository.findById(teacher.getId())
                .orElseThrow(() -> new EntityNotFoundException("Enseignant avec l'ID " + teacher.getId() + " non trouvé."));

        // Mettre à jour les propriétés nécessaires
        existingTeacher.setVacant(teacher.isVacant());
        existingTeacher.setMatiereEnseigne(teacher.getMatiereEnseigne());
        existingTeacher.setProchainCours(teacher.getProchainCours());
        existingTeacher.setSujetProchaineReunion(teacher.getSujetProchaineReunion());
        // Note: Assure-toi que les propriétés que tu mets à jour sont effectivement modifiables et pertinentes

        // Enregistrer les modifications
        return teacherRepository.save(existingTeacher);

    }

    @Override
    public List<Teacher> findAll() {
        return teacherRepository.findAll();

    }

    @Override
    public void delete(Long id) {
        if (!teacherRepository.existsById(id)) {
            throw new EntityNotFoundException("Enseignant avec l'ID " + id + " non trouvé.");
        }
        // Supprime l'enseignant par ID
        teacherRepository.deleteById(id);
    }

}
