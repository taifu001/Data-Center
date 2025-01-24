package com.close.ai.dto;

import com.close.ai.enums.pojo.ToolResourceTypeEnum;
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
public class AgentToolResourceDTO {
    private Long agentId;
    private ToolResourceTypeEnum resourceType;
    private Long resourceId;
    private LocalDateTime bindTime;
}
