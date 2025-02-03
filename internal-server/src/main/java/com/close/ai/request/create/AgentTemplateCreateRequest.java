package com.close.ai.request.create;

import com.close.ai.dto.AgentTemplateDTO;
import com.close.ai.enums.pojo.AgentTemplateFunctionSubTypeEnum;
import com.close.ai.enums.pojo.AgentTemplateFunctionTypeEnum;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Data
public class AgentTemplateCreateRequest {
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

    public AgentTemplateDTO toDTO() {
        return AgentTemplateDTO.builder()
                .name(name)
                .description(description)
                .avatar(avatar)
                .version(version)
                .functionType(functionType)
                .subType(subType)
                .state(state)
                .creatorType(creatorType)
                .creator(creator)
                .updaterType(updaterType)
                .updater(updater)
                .releasedTime(releasedTime)
                .build();
    }
}
