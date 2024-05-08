package com.nadhem.users.dto.response;

import com.nadhem.users.entities.Question;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionResponseDto {

    private int questionId;
    private String answer;
    private String question;
    private int interviewId;

    public static QuestionResponseDto toQuestionResponseDto(Question question){
        if (question == null){
            return null;
        }
        return QuestionResponseDto.builder()
                .answer(question.getAnswer())
                .question(question.getQuestion())
                .questionId(question.getQuestionId())
                .interviewId(question.getInterview().getInterviewId())
                .build();
    }


}
