package com.lucca.dto.response;

import com.lucca.entities.Note;
import com.lucca.entities.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor @Builder
public class UserResponseDto {
    private String username;
    private int userId;

    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String city;
    private String country;
    private String roleName;
    private String startDate;
    private int holidayCountDays;
    private List<Note> notes;
    private DepartmentResponseDto departmentResponseDto;

    public static UserResponseDto toUserResponseDto(User user){
        if (user == null){
            return null;
        }

        return UserResponseDto.builder()
                .username(user.getUsername())
                .userId(user.getUserId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .address(user.getAddress())
                .city(user.getCity())
                .country(user.getCountry())
                .startDate(user.getStartDate())
                .holidayCountDays(user.getHolidayCountDays() != null ? user.getHolidayCountDays() : 0)
                .roleName(!user.getRoles().isEmpty() ? user.getRoles().get(0).getRole() : "")
                .notes(user.getNotes())
                .departmentResponseDto(DepartmentResponseDto.toDepartmentResponseDto(user.getDepartment()))
                .build();
    }
}
