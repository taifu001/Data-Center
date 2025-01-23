package com.close.ai.pojo;

import com.close.ai.enums.pojo.UserGroupRoleEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-23
 */
@Data
public class UserGroup {
    private Long userId;
    private Long groupId;
    private UserGroupRoleEnum role;
    private LocalDateTime bindTime;
}
