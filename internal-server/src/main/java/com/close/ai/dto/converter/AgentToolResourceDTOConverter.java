package com.close.ai.dto.converter;

import com.close.ai.dto.AgentToolResourceDTO;
import com.close.ai.pojo.AgentToolResource;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface AgentToolResourceDTOConverter {
    AgentToolResourceDTO fromEntity(AgentToolResource agentToolResource);

    AgentToolResource toEntity(AgentToolResourceDTO agentToolResourceDTO);
}
