package com.close.ai.service;

import com.close.ai.dto.GroupDTO;
import com.close.ai.dto.converter.GroupDTOConverter;
import com.close.ai.mapper.GroupMapper;
import com.close.ai.pojo.Group;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class GroupService {
    private final GroupMapper groupMapper;

    private final GroupDTOConverter groupDTOConverter;

    public GroupService(GroupMapper groupMapper,
                        GroupDTOConverter groupDTOConverter) {
        this.groupMapper = groupMapper;
        this.groupDTOConverter = groupDTOConverter;
    }

    public GroupDTO getGroupById(Long id, boolean isActive) {
        if (id == null) {
            return null;
        }
        Group group = isActive
                ? groupMapper.selectActiveGroupById(id)
                : groupMapper.selectGroupById(id);
        if (group == null) {
            return null;
        }
        return groupDTOConverter.fromEntity(group);
    }
}
