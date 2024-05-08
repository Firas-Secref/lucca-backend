package com.nadhem.users.controller;

import com.nadhem.users.dto.request.InterviewRequestDto;
import com.nadhem.users.dto.request.QuestionInterviewRequestDto;
import com.nadhem.users.dto.response.InterviewResponseDto;
import com.nadhem.users.entities.Interview;
import com.nadhem.users.service.InterviewService;
import com.nadhem.users.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InterviewController {

    @Autowired
    private InterviewService interviewService;

    @Autowired
    private QuestionService questionService;

    @PostMapping("/newInterview")
    public InterviewResponseDto SaveInterview(@RequestBody InterviewRequestDto interviewDto){
        return this.interviewService.saveNewInterview(interviewDto);
    }

    @GetMapping("/getInterview/{interviewId}")
    public InterviewResponseDto getInterviewById(@PathVariable int interviewId){
        return InterviewResponseDto.toInterviewResponseDto(this.interviewService.getInterviewById(interviewId));
    }

    @GetMapping("/getInterviewsByEmployee/{employeeId}")
    public ResponseEntity<List<InterviewResponseDto>> getAllInterviewsByUser(@PathVariable int employeeId){
        return ResponseEntity.ok(this.interviewService.getAllInterviewsByUser(employeeId));
    }

    @GetMapping("/getInterviewDetails/{interviewId}")
    public ResponseEntity<InterviewResponseDto> getInterviewDetails(@PathVariable int interviewId){
        return ResponseEntity.ok(this.interviewService.getInterviewDetails(interviewId));
    }

    @PostMapping("/completeInterview/{interviewId}")
    public ResponseEntity<InterviewResponseDto> completeInterview(@PathVariable int interviewId){
        return ResponseEntity.ok(this.interviewService.completeInterview(interviewId));
    }
}
