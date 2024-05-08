package com.nadhem.users.service;

import com.nadhem.users.dto.request.DepartmentRequestDto;
import com.nadhem.users.entities.Department;
import com.nadhem.users.repos.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department addNewDepartment(Department department){
        return this.departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return this.departmentRepository.findAll();
    }

    public Department getDepartmentById(int departmentId){
        return this.departmentRepository.findById(departmentId).orElseThrow(()-> new RuntimeException("no department much with this id !"));
    }
}
