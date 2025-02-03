package com.close.ai.pojo;

import com.close.ai.enums.pojo.ToolResourceTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Data
public class AgentToolResource {
    private Long agentId;
    private ToolResourceTypeEnum resourceType;
    private Long resourceId;
    private LocalDateTime bindTime;
}
