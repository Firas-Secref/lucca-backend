package com.lucca.dto.request;

import com.lucca.entities.Question;
import lombok.Data;

import java.util.List;

@Data
public class InterviewRequestDto {

    private String interviewDescription;
    private String period;
    private List<Question> questions;
    private int userId;
}
