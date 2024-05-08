package com.nadhem.users.dto.response;

import com.nadhem.users.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CategoryResponseDto {

    private int categoryId;

    private String categoryName;

    public static CategoryResponseDto toCategoryResponseDto(Category category){
        if (category == null){
            return null;
        }

        return CategoryResponseDto.builder()
                .categoryId(category.getCategoryId())
                .categoryName(category.getCategoryName())
                .build();
    }
}
