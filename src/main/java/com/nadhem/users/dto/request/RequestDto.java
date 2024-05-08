package com.nadhem.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class RequestDto {

    private String requestTitle;
    private String requestDescription;
    private Boolean urgent;
    private String startDate;
    private String endDate;

    private int userId;
    private int statusId;
    private int categoryId;
}
