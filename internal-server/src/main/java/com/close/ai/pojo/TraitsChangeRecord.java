package com.close.ai.pojo;

import com.close.ai.enums.pojo.HumanPersonaEnum;
import com.close.ai.enums.pojo.TraitsRecordChangeTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
public class TraitsChangeRecord {
    private Long id;
    private HumanPersonaEnum sourceType;
    private Long sourceId;

    private String oldTraitsJson;
    private String newTraitsJson;

    private TraitsRecordChangeTypeEnum changeType;
    private LocalDateTime changedAt;
}
