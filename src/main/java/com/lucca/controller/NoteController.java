package com.lucca.controller;

import com.lucca.dto.request.NoteUserRequestDto;
import com.lucca.dto.response.UserResponseDto;
import com.lucca.entities.User;
import com.lucca.service.EmailService;
import com.lucca.service.UserServiceImpl;
import com.lucca.entities.Note;
import com.lucca.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/addNote")
    public Note saveNote(@RequestBody Note note){
        return this.noteService.addNote(note);
    }

    @PostMapping("/addNoteToEmployee")
    public UserResponseDto addNoteToEmployee(@RequestBody NoteUserRequestDto noteUserRequestDto){
        User user = this.userService.findUserByUsername(noteUserRequestDto.getUsername());
        this.emailService.sendMail(user.getEmail(), "Note Pour la periode de "+noteUserRequestDto.getNote().getPeriod(),
                "Votre manager vous a attribuer une note de "+ noteUserRequestDto.getNote().getNote() +" /20");
        Note note = this.noteService.addNote(noteUserRequestDto.getNote());
        return this.userService.addNoteToUser(noteUserRequestDto.getUsername(), note.getNoteId());
    }
}
