package com.lucca.service;

import com.lucca.entities.Note;
import com.lucca.repos.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public Note addNote(Note note){
        return this.noteRepository.save(note);
    }


}
