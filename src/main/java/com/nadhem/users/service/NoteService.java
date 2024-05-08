package com.nadhem.users.service;

import com.nadhem.users.entities.Note;
import com.nadhem.users.repos.NoteRepository;
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
