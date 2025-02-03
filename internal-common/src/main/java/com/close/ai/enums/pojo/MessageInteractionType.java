package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Getter
@AllArgsConstructor
public enum MessageInteractionType {
    NORMAL("normal"),
    INPUT("input"),
    OUTPUT("output"),
    INNER_THOUGHT("innerThought"),
    FUNCTION_CALL("functionCall"),
    ;

    private final String interactionType;
}
