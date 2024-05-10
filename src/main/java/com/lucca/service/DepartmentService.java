package com.lucca.service;

import com.lucca.entities.Department;
import com.lucca.repos.DepartmentRepository;
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
