package com.close.ai.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-20
 */
@Data
public class User {
    private Long id;
    // 组织ID (外键)
    private Long organizationId;

    private String email;
    private String password;
    // 近期密码列表 (JSON 格式)
    private String recentPasswords;
    // 手机号前缀，例如 +86
    private String phonePrefix;
    // 用户手机号
    private String phoneNumber;

    private String name;
    private String avatar;
    // 用户状态，0：正常, 1：禁用
    private Integer state;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
