package com.close.ai.pojo;

import com.close.ai.enums.pojo.TraitsRecordChangeTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-1-24
 */
@Data
public class HumanTraitsChangeRecord {
    private Long id;
    private Long humanId;

    private String oldTraits;
    private String newTraits;

    private TraitsRecordChangeTypeEnum changeType;
    private LocalDateTime changedAt;
}
