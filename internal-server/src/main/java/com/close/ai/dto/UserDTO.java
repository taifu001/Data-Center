package com.close.ai.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    // 组织ID (外键)
    private Long organizationId;

    private String email;
    private String password;
    // 最近使用的密码列表, 容量5
    private List<String> recentPasswordList;
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
