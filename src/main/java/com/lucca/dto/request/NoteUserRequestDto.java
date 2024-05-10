package com.lucca.dto.request;

import com.lucca.entities.Note;
import lombok.Data;

@Data
public class NoteUserRequestDto {

    private String username;
    private Note note;
}
