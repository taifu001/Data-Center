package com.close.ai.dto.converter;

import com.close.ai.dto.AgentTemplateDTO;
import com.close.ai.pojo.AgentTemplate;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface AgentTemplateDTOConverter {
    AgentTemplateDTO fromEntity(AgentTemplate agentTemplate);

    AgentTemplate toEntity(AgentTemplateDTO dto);
}
