package com.close.ai.pojo;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-1-20
 */
@Data
public class Robot {
    private Long id;
    private Long productId;
    private String name;
    private String introduction;
    private Integer state;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
