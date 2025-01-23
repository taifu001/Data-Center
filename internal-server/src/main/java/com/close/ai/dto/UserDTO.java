package com.close.ai.dto;


import com.close.ai.pojo.User;
import com.close.ai.utils.JacksonUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author taifu
 * @since 2025-01-20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

    public static UserDTO fromEntity(User user) {
        UserDTO dto = new UserDTO();
        dto.id = user.getId();
        dto.organizationId = user.getOrganizationId();
        dto.email = user.getEmail();
        dto.password = user.getPassword();

        // 将 JSON 字符串解析为 List<String> 并赋值
        List<String> parsedList = JacksonUtil.parseJsonToList(user.getRecentPasswords());
        dto.recentPasswordList = parsedList != null ? parsedList : new ArrayList<>();

        dto.phonePrefix = user.getPhonePrefix();
        dto.phoneNumber = user.getPhoneNumber();
        dto.name = user.getName();
        dto.avatar = user.getAvatar();
        dto.state = user.getState();
        dto.createdTime = user.getCreatedTime();
        dto.updatedTime = user.getUpdatedTime();
        return dto;
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setId(dto.id);
        user.setOrganizationId(dto.organizationId);
        user.setEmail(dto.email);
        user.setPassword(dto.password);

        // 将 List<String> 序列化回 JSON 字符串
        String jsonStr = JacksonUtil.listToJsonString(dto.recentPasswordList);
        user.setRecentPasswords(jsonStr);

        user.setPhonePrefix(dto.phonePrefix);
        user.setPhoneNumber(dto.phoneNumber);
        user.setName(dto.name);
        user.setAvatar(dto.avatar);
        user.setState(dto.state);
        user.setCreatedTime(dto.createdTime);
        user.setUpdatedTime(dto.updatedTime);
        return user;
    }
}
