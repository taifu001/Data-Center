package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Getter
@AllArgsConstructor
public enum ConversationEndpointTypeEnum {
    SYSTEM("system"),
    PERSONA("persona"),
    HUMAN("human"),
    GROUP("group"),
    ;
    private final String endpointType;
}
