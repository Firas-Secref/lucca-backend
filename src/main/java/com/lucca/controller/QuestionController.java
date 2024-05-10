package com.lucca.controller;

import com.lucca.dto.response.QuestionResponseDto;
import com.lucca.service.QuestionService;
import com.lucca.dto.request.update.QuestionAnswerRequestDto;
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
