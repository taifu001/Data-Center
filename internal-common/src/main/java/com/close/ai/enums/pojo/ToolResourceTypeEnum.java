package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Getter
@AllArgsConstructor
public enum ToolResourceTypeEnum {
    TOOL("tool"),
    TOOLKIT("toolkit");
    ;
    private final String type;
}
