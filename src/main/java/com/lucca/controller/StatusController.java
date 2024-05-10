package com.lucca.controller;

import com.lucca.dto.request.update.UpdateRequestStatusDto;
import com.lucca.dto.response.StatusResponseDto;
import com.lucca.entities.Status;
import com.lucca.service.StatusSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {

    @Autowired
    private StatusSevice statusSevice;

    @GetMapping("/status/{statusId}")
    public ResponseEntity<Status> getStatusById(@PathVariable int statusId){
        return ResponseEntity.ok(this.statusSevice.getStatusById(statusId));
    }

    @PostMapping("/changeRequestStatus")
    public ResponseEntity<StatusResponseDto> changeRequestStatus(@RequestBody UpdateRequestStatusDto requestStatusDto){
        return ResponseEntity.ok(this.statusSevice.changeRequestStatus(requestStatusDto.getRequestId(), requestStatusDto.getStatusId()));
    }
}
