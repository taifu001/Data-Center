package com.close.ai.dto.converter;


import com.close.ai.dto.UserDTO;
import com.close.ai.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper(componentModel = "spring")
public interface UserDTOConverter {
    @Mapping(target = "recentPasswordList",
            expression = "java(com.close.ai.utils.JacksonUtil.parseJsonToList(user.getRecentPasswords(), String.class))")
    UserDTO fromEntity(User user);

    @Mapping(target = "recentPasswords",
            expression = "java(com.close.ai.utils.JacksonUtil.listToJson(dto.getRecentPasswordList()))")
    User toEntity(UserDTO dto);
}
