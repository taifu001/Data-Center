package com.close.ai.dto;

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
public class GroupDTO {
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
