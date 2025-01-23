package com.close.ai.pojo;

import com.close.ai.enums.pojo.OrganizationTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-20
 */
@Data
public class Organization {
    private Long id;
    private String name;
    private OrganizationTypeEnum type;
    private Integer state;
    private Boolean isDeleted;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
