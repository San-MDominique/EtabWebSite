package com.example.monwebetable.services.impl;


import com.example.monwebetable.models.NoteFile;
import com.example.monwebetable.repositories.NoteFileRepository;
import com.example.monwebetable.services.NoteFileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteFileServiceImpl implements NoteFileService {
    private final NoteFileRepository noteFileRepository;

    @Override
    public NoteFile save(NoteFile noteFile) {
        return noteFileRepository.save(noteFile);

    }

    @Override
    public Optional<NoteFile> findOne(Long id) {
        return noteFileRepository.findById(id);

    }

    @Override
    public NoteFile upade(NoteFile noteFile) {
        if (noteFile.getId() == null) {
            throw new IllegalArgumentException("L'ID du fichier de notes ne peut pas être nul.");
        }

        // Trouver le fichier de notes existant par ID
        NoteFile existingNoteFile = noteFileRepository.findById(noteFile.getId())
                .orElseThrow(() -> new EntityNotFoundException("Fichier de notes avec l'ID " + noteFile.getId() + " non trouvé."));

        // Mettre à jour les propriétés nécessaires
        existingNoteFile.setNote(noteFile.getNote());
        existingNoteFile.setAnnée(noteFile.getAnnée());
        // Note: Assure-toi que les propriétés que tu mets à jour sont effectivement modifiables et pertinentes

        // Enregistrer les modifications
        return noteFileRepository.save(existingNoteFile);
    }

    @Override
    public List<NoteFile> findAll() {
        return noteFileRepository.findAll();
    }

    @Override
    public List<NoteFile> finAll() {
        return noteFileRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        if (!noteFileRepository.existsById(id)) {
            throw new EntityNotFoundException("Fichier de notes avec l'ID " + id + " non trouvé.");
        }
        // Supprime le fichier de notes par ID
        noteFileRepository.deleteById(id);
    }
}
