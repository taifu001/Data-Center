package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-2
 */
@Getter
@AllArgsConstructor
public enum OwnerTypeEnum {
    INDIVIDUAL("individual"),
    GROUP("group"),
    ORGANIZATION("organization"),
    ;
    private final String owner;
}
