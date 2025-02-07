package com.close.ai.service;

import com.close.ai.dto.AgentDTO;
import com.close.ai.dto.AgentTemplateDTO;
import com.close.ai.dto.converter.AgentDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.AgentMapper;
import com.close.ai.pojo.Agent;
import com.close.ai.request.create.AgentCreateRequest;
import com.close.ai.service.utils.SourceCheckService;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class AgentService {
    private final AgentMapper agentMapper;

    private final AgentTemplateService agentTemplateService;

    private final SourceCheckService sourceCheckService;

    private final AgentDTOConverter agentDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1);
    private final RobotAgentService robotAgentService;

    public AgentService(AgentMapper agentMapper,
                        AgentTemplateService agentTemplateService,
                        SourceCheckService sourceCheckService,
                        AgentDTOConverter agentDTOConverter,
                        RobotAgentService robotAgentService) {
        this.agentMapper = agentMapper;
        this.agentTemplateService = agentTemplateService;
        this.sourceCheckService = sourceCheckService;
        this.agentDTOConverter = agentDTOConverter;
        this.robotAgentService = robotAgentService;
    }

    public AgentDTO getAgentById(Long id, boolean isActive) {
        if (id == null) {
            return null;
        }
        Agent agent = isActive
                ? agentMapper.selectActiveAgentById(id)
                : agentMapper.selectAgentById(id);
        if (agent == null) {
            return null;
        }
        return agentDTOConverter.fromEntity(agent);
    }

    @Transactional
    public void createAgent(AgentCreateRequest request) {
        if (request == null || request.getRobotId() == null ||
                request.getAgentTemplateId() == null || request.getOwnerType() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        AgentTemplateDTO agentTemplateDTO = agentTemplateService.getAgentTemplateById(request.getAgentTemplateId());
        if (agentTemplateDTO == null) {
            throw new IllegalStateException("Agent template does not exist: " + request.getAgentTemplateId());
        }

        if (sourceCheckService.checkSource(request.getOwnerType(), request.getOwnerId()) != ResponseCode.OK) {
            throw new IllegalStateException("Invalid owner information");
        }

        Agent agent = agentDTOConverter.toEntity(request.toDTO());
        Long agentId = IdUtil.getSnowflake().nextId();
        agent.setId(agentId);

        if (agent.getState() == null) {
            agent.setState(0);
        } else if (!VALID_STATES.contains(agent.getState())) {
            throw new IllegalStateException("Invalid agent state: " + agent.getState());
        }

        int res = agentMapper.insertAgent(agent);
        if (res != 1) {
            throw new RuntimeException("Failed to insert agent");
        }

        robotAgentService.createRobotAgent(request.getRobotId(), agentId);
    }
}
