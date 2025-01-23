package com.close.ai.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-23
 */
@Data
public class Group {
    private Long id;
    private Long organizationId;
    private String name;
    private String avatar;
    private Integer state;
    private String description;
    private Integer limitUserAmount;
    private String userAccessRestriction;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
