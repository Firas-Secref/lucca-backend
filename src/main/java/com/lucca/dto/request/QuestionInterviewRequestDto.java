package com.lucca.dto.request;

import com.lucca.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class QuestionInterviewRequestDto {
    private List<Question> questions;
    private int interviewId;
}
