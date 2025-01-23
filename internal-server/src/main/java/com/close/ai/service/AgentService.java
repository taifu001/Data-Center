package com.close.ai.service;

import com.close.ai.dto.converter.AgentDTOConverter;
import com.close.ai.mapper.AgentMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class AgentService {
    private final AgentMapper agentMapper;

    private final AgentDTOConverter agentDTOConverter;

    public AgentService(AgentMapper agentMapper,
                        AgentDTOConverter agentDTOConverter) {
        this.agentMapper = agentMapper;
        this.agentDTOConverter = agentDTOConverter;
    }
}
