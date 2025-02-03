package com.close.ai.pojo;

import com.close.ai.enums.pojo.AgentTemplateFunctionSubTypeEnum;
import com.close.ai.enums.pojo.AgentTemplateFunctionTypeEnum;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Data
public class AgentTemplate {
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
