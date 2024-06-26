package com.lucca.service;

import com.lucca.dto.response.StatusResponseDto;
import com.lucca.repos.HolidayRepository;
import com.lucca.repos.StatusRepository;
import com.lucca.entities.Request;
import com.lucca.entities.Status;
import com.lucca.repos.RequestRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class StatusSevice {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private HolidayService holidayService;

    public Status getStatusById(int statusId){
        return this.statusRepository.findById(statusId).orElseThrow(()-> new RuntimeException("no status match with this ID !"));
    }

    public Status saveStatus(Status status){
        return this.statusRepository.save(status);
    }

    @Transactional
    public StatusResponseDto changeRequestStatus(int requestId, int statusId){
        Request request = this.requestRepository.findById(requestId).orElseThrow(()-> new RuntimeException("No request much with this id !"));
        Status status = this.statusRepository.findById(statusId).orElseThrow(()-> new RuntimeException("No Status much with this id !"));
        request.setStatus(status);
        int countHolidayDay = Period.between(LocalDate.parse(request.getStartDate()), LocalDate.parse(request.getEndDate())).getDays()+1;
        if (statusId == 2 && (request.getCategory().getCategoryId() == 1 || request.getCategory().getCategoryId() == 2)){
            this.holidayService.addHolidayToUser(countHolidayDay, request.getUser().getUserId());
        }

        return StatusResponseDto.toStatusResponseDto(status);
    }
}
