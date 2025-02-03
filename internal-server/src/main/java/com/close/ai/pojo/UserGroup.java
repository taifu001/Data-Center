package com.close.ai.pojo;

import com.close.ai.enums.pojo.UserGroupRoleEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Data
public class UserGroup {
    private Long userId;
    private Long groupId;
    private UserGroupRoleEnum role;
    private LocalDateTime bindTime;
}
