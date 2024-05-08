package com.nadhem.users.dto.request.update;

import com.nadhem.users.dto.request.UserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class UpdateUserRequestDto extends UserRequestDto {

    private int departmentId;

}
