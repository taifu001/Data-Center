package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Getter
@AllArgsConstructor
public enum MessageSummaryTypeEnum {
    INDIVIDUAL("individual"),
    GROUP("group"),
    ;
    private final String messageSummaryType;

}
