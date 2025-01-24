package com.close.ai.dto.converter;

import com.close.ai.dto.UserGroupDTO;
import com.close.ai.pojo.UserGroup;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface UserGroupDTOConverter {
    UserGroupDTO fromEntity(UserGroup userGroup);

    UserGroup toEntity(UserGroupDTO dto);
}
