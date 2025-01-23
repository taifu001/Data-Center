package com.close.ai.dto.converter;

import com.close.ai.dto.OrganizationDTO;
import com.close.ai.pojo.Organization;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface OrganizationDTOConverter {
    OrganizationDTO fromEntity(Organization organization);

    Organization toEntity(OrganizationDTO organizationDTO);
}
