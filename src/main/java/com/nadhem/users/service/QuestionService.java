package com.nadhem.users.service;

import com.nadhem.users.dto.request.QuestionInterviewRequestDto;
import com.nadhem.users.dto.request.update.QuestionAnswerRequestDto;
import com.nadhem.users.entities.Interview;
import com.nadhem.users.entities.Question;
import com.nadhem.users.repos.QuestionRepository;
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
