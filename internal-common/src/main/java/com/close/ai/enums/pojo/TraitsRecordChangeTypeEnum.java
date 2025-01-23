package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Getter
@AllArgsConstructor
public enum TraitsRecordChangeTypeEnum {
    INSERT("Insert"),
    UPDATE("Update"),
    DELETE("Delete")
    ;
    private final String changeType;
}
