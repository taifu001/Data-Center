package com.close.ai.dto;

import com.close.ai.enums.pojo.SourceCodeLanguageEnum;
import lombok.AllArgsConstructor;
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
public class ToolDTO {
    private Long id;
    private String name;
    private String avatar;
    private String tags;
    private String description;

    // 源码
    private String sourceCode;
    // 源码语言
    private SourceCodeLanguageEnum sourceCodeLanguageEnum;

    private Boolean isTemplate;
    private String version;

    // 状态，0:正常 1:已失效 2: 已废弃
    private Integer state;

    private Long createdBy;
    private String createdByType;
    private Long lastUpdatedBy;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
