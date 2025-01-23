package com.close.ai.dto;

import com.close.ai.enums.pojo.AgentTemplateFunctionSubTypeEnum;
import com.close.ai.enums.pojo.AgentTemplateFunctionTypeEnum;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import com.close.ai.pojo.AgentTemplate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentTemplateDTO {
    private Long id;
    private String name;
    private String description;
    private String avatar;
    private String version;

    // 主要功能类型
    private AgentTemplateFunctionTypeEnum functionType;
    // 更细分子类型
    private AgentTemplateFunctionSubTypeEnum subType;
    // 代理模板状态 0:正常 1:未发布 2:已失效 3: 已废弃
    private Integer state;

    private OwnerTypeEnum creatorType;
    private Long creator;
    private OwnerTypeEnum updaterType;
    private Long updater;

    private LocalDateTime releasedTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static AgentTemplateDTO fromEntity(AgentTemplate agentTemplate) {
        AgentTemplateDTO dto = new AgentTemplateDTO();
        dto.setId(agentTemplate.getId());
        dto.setName(agentTemplate.getName());
        dto.setDescription(agentTemplate.getDescription());
        dto.setAvatar(agentTemplate.getAvatar());
        dto.setVersion(agentTemplate.getVersion());
        dto.setFunctionType(agentTemplate.getFunctionType());
        dto.setSubType(agentTemplate.getSubType());
        dto.setState(agentTemplate.getState());
        dto.setCreatorType(agentTemplate.getCreatorType());
        dto.setCreator(agentTemplate.getCreator());
        dto.setUpdaterType(agentTemplate.getUpdaterType());
        dto.setUpdater(agentTemplate.getUpdater());
        dto.setReleasedTime(agentTemplate.getReleasedTime());
        dto.setCreatedTime(agentTemplate.getCreatedTime());
        dto.setUpdatedTime(agentTemplate.getUpdatedTime());
        return dto;
    }

    public static AgentTemplate toEntity(AgentTemplateDTO dto) {
        AgentTemplate agentTemplate = new AgentTemplate();
        agentTemplate.setId(dto.getId());
        agentTemplate.setName(dto.getName());
        agentTemplate.setDescription(dto.getDescription());
        agentTemplate.setAvatar(dto.getAvatar());
        agentTemplate.setVersion(dto.getVersion());
        agentTemplate.setFunctionType(dto.getFunctionType());
        agentTemplate.setSubType(dto.getSubType());
        agentTemplate.setState(dto.getState());
        agentTemplate.setCreatorType(dto.getCreatorType());
        agentTemplate.setCreator(dto.getCreator());
        agentTemplate.setUpdaterType(dto.getUpdaterType());
        agentTemplate.setUpdater(dto.getUpdater());
        agentTemplate.setReleasedTime(dto.getReleasedTime());
        agentTemplate.setCreatedTime(dto.getCreatedTime());
        agentTemplate.setUpdatedTime(dto.getUpdatedTime());
        return agentTemplate;
    }
}
