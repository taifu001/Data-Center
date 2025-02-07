package com.close.ai.response;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class PersonaResponse {
    private Long id;
    private Long agentId;
    // 人格状态 0:正常 1:失效
    private Integer state;
    private String traitsJson;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
