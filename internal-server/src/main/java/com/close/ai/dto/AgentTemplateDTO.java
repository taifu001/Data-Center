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
 * @author nbwyctf
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
}
