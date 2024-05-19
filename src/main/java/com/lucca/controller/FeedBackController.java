package com.lucca.controller;

import com.lucca.dto.request.FeedBackRequestDto;
import com.lucca.dto.response.FeedBackResponseDTO;
import com.lucca.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FeedBackController {

    @Autowired
    private FeedBackService feedBackService;

    @PostMapping("/newFeedback")
    public void saveFeedBack(@RequestBody FeedBackRequestDto feedBack){
        this.feedBackService.addNewFeedBack(feedBack);
    }

    @GetMapping("/employeeFeedBack/{candidateId}")
    public List<FeedBackResponseDTO > getCandidateFeedBack(@PathVariable Integer candidateId){
        return this.feedBackService.getEmployeeFeedBack(candidateId);
    }
}
