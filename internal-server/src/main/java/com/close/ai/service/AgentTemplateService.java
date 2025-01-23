package com.close.ai.service;

import com.close.ai.dto.converter.AgentTemplateDTOConverter;
import com.close.ai.mapper.AgentTemplateMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class AgentTemplateService {
    private final AgentTemplateMapper agentTemplateMapper;

    private final AgentTemplateDTOConverter agentTemplateDTOConverter;

    public AgentTemplateService(AgentTemplateMapper agentTemplateMapper,
                                AgentTemplateDTOConverter agentTemplateDTOConverter) {
        this.agentTemplateMapper = agentTemplateMapper;
        this.agentTemplateDTOConverter = agentTemplateDTOConverter;
    }
}
