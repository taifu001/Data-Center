package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-2
 */
@Getter
@AllArgsConstructor
public enum ProductTypeEnum {
    PHYSICAL_PRODUCT("PhysicalProduct"),
    PHYSICAL_COMPONENT("PhysicalComponent"),
    VIRTUAL_PRODUCT("VirtualProduct"),
    ;
    private final String type;

}
