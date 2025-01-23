package com.close.ai.dto;

import com.close.ai.enums.pojo.OwnerTypeEnum;
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
public class RobotDTO {
    private Long id;
    private Long productId;
    private String name;
    private String version;
    private String introduction;
    private Integer state;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
