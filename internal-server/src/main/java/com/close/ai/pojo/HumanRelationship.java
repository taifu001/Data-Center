package com.close.ai.pojo;

import com.close.ai.enums.pojo.HumanRelationshipTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-1-22
 */
@Data
public class HumanRelationship {
    private Long id;
    private Integer state;
    private Long fromHumanId;
    private Long toHumanId;
    private HumanRelationshipTypeEnum humanRelationshipType;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
