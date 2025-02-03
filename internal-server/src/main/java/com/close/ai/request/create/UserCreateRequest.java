package com.close.ai.request.create;

import com.close.ai.dto.UserDTO;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-01-22
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
                .email(email)
                .password(password)
                .phonePrefix(phonePrefix)
                .phoneNumber(phoneNumber)
                .name(name)
                .build();
    }
}
