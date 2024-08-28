package com.example.monwebetable.services;

import com.example.monwebetable.models.NoteFile;

import java.util.List;
import java.util.Optional;

public interface NoteFileService {
    NoteFile save(NoteFile noteFile);
    Optional<NoteFile> findOne(Long id);
    NoteFile upade(NoteFile noteFile);

    List<NoteFile> findAll();

    List<NoteFile> finAll();

    void delete(Long id);
}
