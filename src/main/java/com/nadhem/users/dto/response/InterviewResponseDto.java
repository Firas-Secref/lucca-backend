package com.nadhem.users.dto.response;

import com.nadhem.users.dto.request.InterviewRequestDto;
import com.nadhem.users.entities.Interview;
import com.nadhem.users.entities.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InterviewResponseDto {

    private int interviewId;
    private String interviewDescription;
    private boolean completed;
    private String period;
    private List<QuestionResponseDto> questions;
    private int userId;
    private String userFullName;

    public static InterviewResponseDto toInterviewResponseDto(Interview interview){
        if (interview == null){
            return null;
        }

        return InterviewResponseDto.builder()
                .interviewDescription(interview.getInterviewDescription())
                .interviewId(interview.getInterviewId())
                .questions(interview.getQuestions().stream().map(QuestionResponseDto::toQuestionResponseDto).collect(Collectors.toList()))
                .completed(interview.isCompleted())
                .userId(interview.getUser().getUserId())
                .period(interview.getPeriod())
                .userFullName(interview.getUser().getFirstname() + " " +interview.getUser().getLastname())
                .build();
    }
}
