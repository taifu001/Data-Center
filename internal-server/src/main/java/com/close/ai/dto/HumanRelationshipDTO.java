package com.close.ai.dto;

import com.close.ai.enums.pojo.HumanRelationshipTypeEnum;
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
public class HumanRelationshipDTO {
    private Long id;
    private Integer state;
    private Long fromHumanId;
    private Long toHumanId;
    private HumanRelationshipTypeEnum humanRelationshipType;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
