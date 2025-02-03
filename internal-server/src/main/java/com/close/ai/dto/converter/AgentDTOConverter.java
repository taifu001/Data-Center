package com.close.ai.dto.converter;

import com.close.ai.dto.AgentDTO;
import com.close.ai.pojo.Agent;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface AgentDTOConverter {
    AgentDTO fromEntity(Agent agentTemplate);

    Agent toEntity(AgentDTO dto);
}
