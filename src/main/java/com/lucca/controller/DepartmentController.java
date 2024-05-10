package com.lucca.controller;

import com.lucca.dto.response.DepartmentResponseDto;
import com.lucca.entities.Department;
import com.lucca.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/addDepartment")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(this.departmentService.addNewDepartment(department));
    }

    @GetMapping("/allDepartments")
    public ResponseEntity<List<DepartmentResponseDto>> getAllDepartments(){
        return ResponseEntity.ok(this.departmentService.getAllDepartments().stream().map(DepartmentResponseDto::toDepartmentResponseDto).collect(Collectors.toList()));
    }
}
