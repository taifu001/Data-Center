package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-02-07
 */
@Getter
@AllArgsConstructor
public enum HumanPersonaEnum {
    HUMAN("human"),
    PERSONA("persona"),
    ;
    private final String value;
}
