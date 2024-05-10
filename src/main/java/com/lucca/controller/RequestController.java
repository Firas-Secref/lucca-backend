package com.lucca.controller;

import com.lucca.dto.request.RequestDto;
import com.lucca.dto.response.RequestResponseDto;
import com.lucca.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestController {

    @Autowired
    private RequestService requestService;

    @PostMapping("/addNewRequest")
    public ResponseEntity<RequestResponseDto> addNewRequest(@RequestBody RequestDto request){
        return ResponseEntity.ok(this.requestService.addNewRequest(request));
    }

    @GetMapping("/getRequestSentToRh")
    public ResponseEntity<List<RequestResponseDto>> getAllRequestSentToRh(){
        return ResponseEntity.ok(this.requestService.getAllRequestsForRhUser());
    }

    @GetMapping("/getMyRequests/{employeeId}")
    public ResponseEntity<List<RequestResponseDto>> getMyRequests(@PathVariable int employeeId){
        return ResponseEntity.ok(this.requestService.getMyRequests(employeeId));
    }

    @GetMapping("/getMyEmployeeRequests/{managerId}")
    public ResponseEntity<List<RequestResponseDto>> getMyEmployeeRequests(@PathVariable int managerId){
        return ResponseEntity.ok(this.requestService.getMyEmployeeRequests(managerId));
    }

    @GetMapping("/getAllEmployeesHolidays")
    public ResponseEntity<List<RequestResponseDto>> getAllEmployeesHolidays(){
        return ResponseEntity.ok(this.requestService.getAllEmployeesHolidays());
    }

    @GetMapping("/getMytHomeOfficeRequest/{employeeId}")
    public ResponseEntity<List<RequestResponseDto>> geMytHomeOfficeRequest(@PathVariable int employeeId){
        return ResponseEntity.ok(this.requestService.geMytHomeOfficeRequest(employeeId));
    }

    @GetMapping("/getAllHomeOfficeRequests")
    public ResponseEntity<List<RequestResponseDto>> getAllHomeOfficeRequest(){
        return ResponseEntity.ok(this.requestService.getAllHomeOfficeRequest());
    }





}
