package com.lucca.service;

import com.lucca.dto.request.RequestDto;
import com.lucca.dto.response.RequestResponseDto;
import com.lucca.entities.Category;
import com.lucca.entities.User;
import com.lucca.entities.Request;
import com.lucca.entities.Status;
import com.lucca.repos.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private StatusSevice statusSevice;

    @Autowired
    private CategoryService categoryService;

    public RequestResponseDto addNewRequest(RequestDto requestDto){
        Request request= new Request();
        User fromUser = this.userService.getUserById(requestDto.getUserId());
        Status status = this.statusSevice.getStatusById(requestDto.getStatusId());
        Category category = this.categoryService.getCategoryById(requestDto.getCategoryId());
        request.setUser(fromUser);
        request.setStatus(status);
        request.setCategory(category);
        request.setRequestTitle(requestDto.getRequestTitle());
        request.setRequestDescription(requestDto.getRequestDescription());
        request.setUrgent(requestDto.getUrgent());
        request.setStartDate(requestDto.getStartDate());
        request.setEndDate(requestDto.getEndDate());
        return RequestResponseDto.toRequestResponseDto(this.requestRepository.save(request));
    }

    public List<RequestResponseDto> getAllRequestsForRhUser(){
        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId")).stream().map(RequestResponseDto::toRequestResponseDto).collect(Collectors.toList());
    }

    public List<RequestResponseDto> getMyRequests(int employeeId){
        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId"))
                .stream()
                .filter(r-> r.getUser().getUserId() == employeeId)
                .map(RequestResponseDto::toRequestResponseDto)
                .collect(Collectors.toList());
    }

    public List<RequestResponseDto> getMyEmployeeRequests(int managerId){
        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId"))
                .stream()
                .filter(r-> r.getUser().getManagerId() == managerId)
                .map(RequestResponseDto::toRequestResponseDto)
                .collect(Collectors.toList());
    }

    public List <RequestResponseDto> getAllEmployeesHolidays(){

        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId"))
                .stream()
                .filter(r->r.getCategory().getCategoryName().equals("PAID VACATION") || r.getCategory().getCategoryName().equals("MEDICAL LEAVE"))
                .map(RequestResponseDto::toRequestResponseDto)
                .collect(Collectors.toList());

    }

    public List<RequestResponseDto> geMytHomeOfficeRequest(int employeeId){
        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId"))
                .stream()
                .filter(r->r.getCategory().getCategoryName().equals("HOME OFFICE") && r.getUser().getUserId() == employeeId)
                .map(RequestResponseDto::toRequestResponseDto)
                .collect(Collectors.toList());
    }

    public List<RequestResponseDto> getAllHomeOfficeRequest(){
        return this.requestRepository.findAll(Sort.by(Sort.Direction.DESC, "requestId"))
                .stream()
                .filter(r->r.getCategory().getCategoryName().equals("HOME OFFICE"))
                .map(RequestResponseDto::toRequestResponseDto)
                .collect(Collectors.toList());
    }





}