package com.close.ai.request;

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

    public UserDTO toUserDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(this.email);
        userDTO.setPassword(this.password);
        userDTO.setPhonePrefix(this.phonePrefix);
        userDTO.setPhoneNumber(this.phoneNumber);
        userDTO.setName(this.name);
        return userDTO;
    }
}
