package com.lucca.dto.response;

import com.lucca.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponseDto {

    private int departmentId;
    private String departmentName;

    public static DepartmentResponseDto toDepartmentResponseDto(Department department){
        if (department == null) {
            return null;
        };
        return DepartmentResponseDto.builder()
                .departmentId(department.getDepartmentId())
                .departmentName(department.getDepartmentName())
                .build();
    }

}
