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
public class HumanDTO {
    private Long id;

    /** 关联的用户ID */
    private Long userId;

    /** 人物状态 0:正常 1:失效 */
    private Integer state;

    /** 人物特征 */
    private String traitsJson;

    /** 记录创建时间 */
    private LocalDateTime createdTime;

    /** 记录最后更新时间 */
    private LocalDateTime updatedTime;
}
