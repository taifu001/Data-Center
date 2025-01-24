package com.close.ai.service;

import com.close.ai.dto.converter.UserGroupDTOConverter;
import com.close.ai.mapper.UserGroupMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class UserGroupService {
    private final UserGroupMapper userGroupMapper;

    private final UserGroupDTOConverter userGroupDTOConverter;

    public UserGroupService(UserGroupMapper userGroupMapper,
                            UserGroupDTOConverter userGroupDTOConverter) {
        this.userGroupMapper = userGroupMapper;
        this.userGroupDTOConverter = userGroupDTOConverter;
    }
}
