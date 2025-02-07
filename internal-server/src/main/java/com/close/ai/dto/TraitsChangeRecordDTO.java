package com.close.ai.dto;

import com.close.ai.enums.pojo.HumanPersonaEnum;
import com.close.ai.enums.pojo.TraitsRecordChangeTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TraitsChangeRecordDTO {
    private Long id;
    private HumanPersonaEnum sourceType;
    private Long sourceId;

    private String oldTraitsJson;
    private String newTraitsJson;

    private TraitsRecordChangeTypeEnum changeType;
    private LocalDateTime changedAt;
}
