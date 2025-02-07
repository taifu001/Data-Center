package com.close.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonaDTO {
    private Long id;
    private Long agentId;
    // 人格状态 0:正常 1:失效
    private Integer state;
    private String traitsJson;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
