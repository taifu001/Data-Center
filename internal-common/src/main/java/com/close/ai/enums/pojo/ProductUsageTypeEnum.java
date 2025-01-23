package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author taifu
 * @since 2025-01-2
 */
@Getter
@AllArgsConstructor
public enum ProductUsageTypeEnum {
    VOICE_COMPANION("VoiceCompanion"),
    OTHER("Other")
    ;

    private final String usage;
}
