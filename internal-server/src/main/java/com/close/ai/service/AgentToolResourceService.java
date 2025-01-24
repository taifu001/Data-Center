package com.close.ai.service;

import com.close.ai.dto.converter.AgentToolResourceDTOConverter;
import com.close.ai.mapper.AgentToolResourceMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class AgentToolResourceService {
    private final AgentToolResourceMapper agentToolResourceMapper;

    private final AgentToolResourceDTOConverter agentToolResourceDTOConverter;

    public AgentToolResourceService(AgentToolResourceMapper agentToolResourceMapper,
                                    AgentToolResourceDTOConverter agentToolResourceDTOConverter) {
        this.agentToolResourceMapper = agentToolResourceMapper;
        this.agentToolResourceDTOConverter = agentToolResourceDTOConverter;
    }
}
