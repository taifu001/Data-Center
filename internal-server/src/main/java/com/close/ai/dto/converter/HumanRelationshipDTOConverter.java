package com.close.ai.dto.converter;

import com.close.ai.dto.HumanRelationshipDTO;
import com.close.ai.pojo.HumanRelationship;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface HumanRelationshipDTOConverter {
    HumanRelationshipDTO fromEntity(HumanRelationship humanRelationship);

    HumanRelationship toEntity(HumanRelationshipDTO humanRelationshipDTO);
}
