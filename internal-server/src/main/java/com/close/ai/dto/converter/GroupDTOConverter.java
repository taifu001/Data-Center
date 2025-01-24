package com.close.ai.dto.converter;

import com.close.ai.dto.GroupDTO;
import com.close.ai.pojo.Group;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface GroupDTOConverter {
    GroupDTO fromEntity(Group group);

    Group toEntity(GroupDTO dto);
}
