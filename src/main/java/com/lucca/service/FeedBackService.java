package com.lucca.service;

import com.lucca.dto.request.FeedBackRequestDto;
import com.lucca.dto.response.FeedBackResponseDTO;
import com.lucca.entities.FeedBack;
import com.lucca.entities.User;
import com.lucca.repos.FeedBackRepository;
import com.lucca.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FeedBackService {

    @Autowired
    private FeedBackRepository feedBackRepository;

    @Autowired
    private UserRepository userRepository;

    public void addNewFeedBack(FeedBackRequestDto feedBackrequestDto){
        User employee = this.userRepository.findById(feedBackrequestDto.getUserId()).get();
        this.feedBackRepository.save(new FeedBack(null, feedBackrequestDto.getFeedBackText(), feedBackrequestDto.getUserId(),feedBackrequestDto.getFeedBackType(), employee));
        //this.feedBachRepository.save(feedBack);
    }

    public List<FeedBackResponseDTO> getEmployeeFeedBack(Integer employeeId){
        return this.feedBackRepository.findAll().stream().filter(feedBack -> feedBack.getEmployeeId() == employeeId)
                .map(FeedBackResponseDTO::toFeedBackResponseDto)
                .collect(Collectors.toList());
    }
}
