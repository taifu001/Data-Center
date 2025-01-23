package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Getter
@AllArgsConstructor
public enum UserGroupRoleEnum {
    OWNER("owner"),
    ADMIN("admin"),
    MEMBER("member")
    ;
    private final String role;
}
