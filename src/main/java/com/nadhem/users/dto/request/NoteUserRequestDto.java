package com.nadhem.users.dto.request;

import com.nadhem.users.entities.Note;
import lombok.Data;

@Data
public class NoteUserRequestDto {

    private String username;
    private Note note;
}
