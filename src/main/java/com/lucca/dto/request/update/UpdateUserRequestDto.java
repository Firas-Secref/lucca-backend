package com.lucca.dto.request.update;

import com.lucca.dto.request.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UpdateUserRequestDto extends UserRequestDto {

    private int departmentId;

}
