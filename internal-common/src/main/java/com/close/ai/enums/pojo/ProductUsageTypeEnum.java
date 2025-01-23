package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Getter
@AllArgsConstructor
public enum ProductUsageTypeEnum {
    VOICE_COMPANION("VoiceCompanion"),
    OTHER("Other")
    ;

    private final String usage;
}
