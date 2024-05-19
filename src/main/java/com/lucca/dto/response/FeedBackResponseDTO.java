package com.lucca.dto.response;


import com.lucca.entities.Category;
import com.lucca.entities.FeedBack;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
public class FeedBackResponseDTO {

    private Integer feedBackId;
    private String feedBackText;
    private int employeeId;
    private String userFirstname;
    private String userLastname;
    private String feedBackType;

    public static FeedBackResponseDTO toFeedBackResponseDto(FeedBack feedback){
        if (feedback == null){
            return null;
        }

        return FeedBackResponseDTO.builder()
                .feedBackId(feedback.getFeedBackId())
                .employeeId(feedback.getEmployeeId())
                .feedBackText(feedback.getFeedBackText())
                .feedBackType(feedback.getFeedBackType())
                .userFirstname(feedback.getUser() != null ? feedback.getUser().getFirstname() : "")
                .userLastname(feedback.getUser() != null ? feedback.getUser().getLastname() : "")
                .build();
    }
}
