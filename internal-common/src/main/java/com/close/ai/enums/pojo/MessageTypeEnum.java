package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Getter
@AllArgsConstructor
public enum MessageTypeEnum {
    TEXT("TEXT"),
    EMOTION("EMOTION"),
    IMAGE("IMAGE"),
    VOICE("VOICE"),
    VIDEO("VIDEO"),
    FILE("FILE"),
    ;
    private final String messageType;
}
