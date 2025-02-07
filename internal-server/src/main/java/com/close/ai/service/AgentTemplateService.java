package com.close.ai.service;

import com.close.ai.dto.AgentTemplateDTO;
import com.close.ai.dto.converter.AgentTemplateDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.enums.pojo.AgentTemplateFunctionSubTypeEnum;
import com.close.ai.enums.pojo.AgentTemplateFunctionTypeEnum;
import com.close.ai.mapper.AgentTemplateMapper;
import com.close.ai.pojo.AgentTemplate;
import com.close.ai.request.create.AgentTemplateCreateRequest;
import com.close.ai.service.utils.SourceCheckService;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class AgentTemplateService {
    private final AgentTemplateMapper agentTemplateMapper;

    private final SourceCheckService sourceCheckService;

    private final AgentTemplateDTOConverter agentTemplateDTOConverter;


    private static final Set<Integer> VALID_STATES = Set.of(0, 1, 2, 3);

    public AgentTemplateService(AgentTemplateMapper agentTemplateMapper,
                                SourceCheckService sourceCheckService,
                                AgentTemplateDTOConverter agentTemplateDTOConverter) {
        this.agentTemplateMapper = agentTemplateMapper;
        this.sourceCheckService = sourceCheckService;
        this.agentTemplateDTOConverter = agentTemplateDTOConverter;
    }

    public AgentTemplateDTO getAgentTemplateById(Long id) {
        if (id == null) {
            return null;
        }
        AgentTemplate agentTemplate = agentTemplateMapper.selectActiveAgentTemplateById(id);
        if (agentTemplate == null) {
            return null;
        }
        return agentTemplateDTOConverter.fromEntity(agentTemplate);
    }

    @Transactional
    public void createAgentTemplate(AgentTemplateCreateRequest request) {
        if (request == null || request.getName() == null || request.getCreatorType() == null || request.getUpdaterType() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        // 校验创建者与更新者
        if (sourceCheckService.checkSource(request.getCreatorType(), request.getCreator()) != ResponseCode.OK) {
            throw new IllegalStateException("Invalid creator information");
        }
        if (sourceCheckService.checkSource(request.getUpdaterType(), request.getUpdater()) != ResponseCode.OK) {
            throw new IllegalStateException("Invalid updater information");
        }

        AgentTemplate agentTemplate = agentTemplateDTOConverter.toEntity(request.toDTO());
        agentTemplate.setId(IdUtil.getSnowflake().nextId());

        if (agentTemplate.getFunctionType() == null) {
            agentTemplate.setFunctionType(AgentTemplateFunctionTypeEnum.UNDEFINED);
        }
        if (agentTemplate.getSubType() == null) {
            agentTemplate.setSubType(AgentTemplateFunctionSubTypeEnum.UNDEFINED);
        }

        if (agentTemplate.getState() == null) {
            agentTemplate.setState(0);
        } else if (!VALID_STATES.contains(agentTemplate.getState())) {
            throw new IllegalStateException("Invalid agent template state: " + agentTemplate.getState());
        }

        int res = agentTemplateMapper.insertAgentTemplate(agentTemplate);
        if (res != 1) {
            throw new RuntimeException("Failed to insert agent template");
        }
    }

}
