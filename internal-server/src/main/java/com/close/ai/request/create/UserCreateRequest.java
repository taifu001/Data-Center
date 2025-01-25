package com.close.ai.request.create;

import com.close.ai.dto.UserDTO;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-1-22
 */
@Data
public class UserCreateRequest {
    private String email;
    private String password;
    private String phonePrefix;
    private String phoneNumber;
    private String name;

    public UserDTO toDTO() {
        return UserDTO.builder()
                .email(this.email)
                .password(this.password)
                .phonePrefix(this.phonePrefix)
                .phoneNumber(this.phoneNumber)
                .name(this.name)
                .build();
    }
}
