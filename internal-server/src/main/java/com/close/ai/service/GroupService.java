package com.close.ai.service;

import com.close.ai.dto.converter.GroupDTOConverter;
import com.close.ai.mapper.GroupMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class GroupService {
    final GroupMapper groupMapper;

    final GroupDTOConverter groupDTOConverter;

    public GroupService(GroupMapper groupMapper,
                        GroupDTOConverter groupDTOConverter) {
        this.groupMapper = groupMapper;
        this.groupDTOConverter = groupDTOConverter;
    }
}
