package com.nadhem.users.dto.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateRequestStatusDto {

    int requestId;
    int statusId;
}
