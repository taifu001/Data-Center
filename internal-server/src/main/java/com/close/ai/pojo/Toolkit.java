package com.close.ai.pojo;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-23
 */
@Data
public class Toolkit {
    private Long id;
    private String name;
    private String avatar;
    private String description;
    private String tags;
    private String version;
    // 状态，0:正常 1:已失效 2:已废弃
    private Integer state;
    private Long createdBy;
    private OwnerTypeEnum createdByType;
    private Long lastUpdatedBy;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
