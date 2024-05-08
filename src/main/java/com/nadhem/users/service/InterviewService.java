package com.nadhem.users.service;

import com.nadhem.users.dto.request.InterviewRequestDto;
import com.nadhem.users.dto.response.InterviewResponseDto;
import com.nadhem.users.entities.Interview;
import com.nadhem.users.entities.Question;
import com.nadhem.users.entities.User;
import com.nadhem.users.repos.InterviewRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InterviewService {

    @Autowired
    private InterviewRepository interviewRepository;

    @Autowired
    private UserServiceImpl userService;

    @Transactional
    public InterviewResponseDto saveNewInterview(InterviewRequestDto interviewDto){
        Interview interview = new Interview();
        User relatedUser = this.userService.getUserById(interviewDto.getUserId());
        interview.setInterviewDescription(interviewDto.getInterviewDescription());
        interview.setQuestions(interviewDto.getQuestions());
        interview.setPeriod(interviewDto.getPeriod());
        interview.setUser(relatedUser);
        var savedInterview = this.interviewRepository.save(interview);
        interview.getQuestions().forEach(q-> q.setInterview(savedInterview));
        return InterviewResponseDto.toInterviewResponseDto(savedInterview);

    }

    public Interview getInterviewById(int interviewId){
        return this.interviewRepository.findById(interviewId).orElseThrow(()-> new RuntimeException("No interview match with this ID !"));
    }

    public List<InterviewResponseDto> getAllInterviewsByUser(int userId){
        return this.interviewRepository.findAll()
                .stream()
                .filter(interview -> interview.getUser().getUserId() == userId)
                .map(InterviewResponseDto::toInterviewResponseDto)
                .collect(Collectors.toList());
    }


    public InterviewResponseDto getInterviewDetails(int interviewId){
        return InterviewResponseDto.toInterviewResponseDto(this.interviewRepository.findById(interviewId).orElseThrow(()-> new RuntimeException("No interview mush with this ID !")));
    }

    @Transactional
    public InterviewResponseDto completeInterview(int interviewId){
        Interview interview = this.interviewRepository.findById(interviewId).orElseThrow(
                ()-> new RuntimeException("No interview much with this id")
        );

        interview.setCompleted(true);
        return InterviewResponseDto.toInterviewResponseDto(interview);
    }
}
