package com.close.ai.dto;

import com.close.ai.enums.pojo.UserGroupRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDTO {
    private Long userId;
    private Long groupId;
    private UserGroupRoleEnum role;
    private LocalDateTime bindTime;
}
