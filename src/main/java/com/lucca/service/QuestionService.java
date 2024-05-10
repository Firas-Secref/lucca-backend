package com.lucca.service;

import com.lucca.entities.Interview;
import com.lucca.repos.QuestionRepository;
import com.lucca.dto.request.QuestionInterviewRequestDto;
import com.lucca.dto.request.update.QuestionAnswerRequestDto;
import com.lucca.entities.Question;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private InterviewService interviewService;


    @Transactional
    public void addQuestionsToInterview(QuestionInterviewRequestDto questionInterviewRequestDto){
        Interview newInterview = this.interviewService.getInterviewById(questionInterviewRequestDto.getInterviewId());
        questionInterviewRequestDto.getQuestions().forEach(q-> newInterview.getQuestions().add(q));
    }

    public List<Question> getAllInterviewsQuestions(int interviewId){
        return this.questionRepository.findAll().stream()
                .filter(question -> question.getInterview().getInterviewId() == interviewId)
                .collect(Collectors.toList());
    }

    public Question addAnswerToQuestion(QuestionAnswerRequestDto questionAnswerRequestDto, int questionId){
        Question question = this.questionRepository.findById(questionId).orElseThrow(
                ()-> new RuntimeException("No question mush with this id !!")
        );
        question.setAnswer(questionAnswerRequestDto.getAnswer());
        return this.questionRepository.save(question);
    }




}
