package com.close.ai.service.utils;

import com.close.ai.dto.*;
import com.close.ai.enums.ResponseCode;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import com.close.ai.service.*;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-02-03
 */
@Service
public class SourceCheckService {
    private final UserService userService;
    private final GroupService groupService;

    private final OrganizationService organizationService;

    public SourceCheckService(UserService userService,
                              GroupService groupService,
                              OrganizationService organizationService) {
        this.userService = userService;
        this.groupService = groupService;
        this.organizationService = organizationService;

    }

    public ResponseCode checkSource(OwnerTypeEnum sourceType, Long sourceId) {
        switch (sourceType) {
            case SYSTEM:
                break;
            case INDIVIDUAL:
                UserDTO user = userService.getUserById(sourceId, true);
                if (user == null) {
                    return ResponseCode.USER_NOT_EXIST;
                }
                break;
            case GROUP:
                GroupDTO group = groupService.getGroupById(sourceId, true);
                if (group == null) {
                    return ResponseCode.GROUP_NOT_EXIST;
                }
                break;
            case ORGANIZATION:
                OrganizationDTO organization = organizationService.getOrganizationById(sourceId, true);
                if (organization == null) {
                    return ResponseCode.ORGANIZATION_NOT_EXIST;
                }
                break;
            default:
                return ResponseCode.SOURCE_TYPE_ERROR;
        }
        return ResponseCode.OK;
    }
}
