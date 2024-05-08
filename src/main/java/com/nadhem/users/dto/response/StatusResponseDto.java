package com.nadhem.users.dto.response;

import com.nadhem.users.entities.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class StatusResponseDto {

    private int statusId;

    private String statusName;
    private String statusColor;

    public static StatusResponseDto toStatusResponseDto(Status status){
        if (status == null){
            return null;
        }
        return StatusResponseDto.builder()
                .statusId(status.getStatusId())
                .statusName(status.getStatusName())
                .statusColor(status.getStatusColor())
                .build();
    }
}
