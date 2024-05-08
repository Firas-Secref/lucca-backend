package com.nadhem.users.dto.request;

import com.nadhem.users.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionInterviewRequestDto {
    private List<Question> questions;
    private int interviewId;
}
