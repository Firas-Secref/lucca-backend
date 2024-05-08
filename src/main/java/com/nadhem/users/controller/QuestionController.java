package com.nadhem.users.controller;

import com.nadhem.users.dto.request.update.QuestionAnswerRequestDto;
import com.nadhem.users.dto.response.QuestionResponseDto;
import com.nadhem.users.entities.Question;
import com.nadhem.users.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/addAnswerToQuestion/{questionId}")
    public QuestionResponseDto addAnswerToQuestion(@RequestBody QuestionAnswerRequestDto questionAnswerRequestDto, @PathVariable int questionId){
        return QuestionResponseDto.toQuestionResponseDto(this.questionService.addAnswerToQuestion(questionAnswerRequestDto, questionId));
    }
}
