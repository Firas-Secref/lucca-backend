package com.lucca.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedBackRequestDto {
    private String feedBackText;
    private int userId;
    private String feedBackType;
}