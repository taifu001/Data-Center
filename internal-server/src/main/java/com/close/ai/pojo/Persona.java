package com.close.ai.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-1-23
 */
@Data
public class Persona {
    private Long id;
    private Long agentId;
    // 人格状态 0:正常 1:失效
    private Integer state;
    // 人格回复使用的语言
    private String language;
    private String traitsJson;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
