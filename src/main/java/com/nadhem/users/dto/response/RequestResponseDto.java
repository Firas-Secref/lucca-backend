package com.nadhem.users.dto.response;

import com.nadhem.users.dto.request.RequestDto;
import com.nadhem.users.entities.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class RequestResponseDto {
    private int requestId;
    private String requestTitle;
    private String requestDescription;
    private Boolean urgent;
    private String startDate;
    private String endDate;
    private UserResponseDto userDto;
    private StatusResponseDto statusDto;
    private CategoryResponseDto categoryDto;

    public static RequestResponseDto toRequestResponseDto(Request request){
        if (request == null){
            return null;
        }
        return RequestResponseDto.builder()
                .requestId(request.getRequestId())
                .requestTitle(request.getRequestTitle())
                .requestDescription(request.getRequestDescription())
                .urgent(request.getUrgent())
                .userDto(UserResponseDto.toUserResponseDto(request.getUser()))
                .statusDto(StatusResponseDto.toStatusResponseDto(request.getStatus()))
                .endDate(request.getEndDate())
                .startDate(request.getStartDate())
                .categoryDto(CategoryResponseDto.toCategoryResponseDto(request.getCategory()))
                .build();
    }
}
