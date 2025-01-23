package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author taifu
 * @since 2025-01-20
 */
@Getter
@AllArgsConstructor
public enum OrganizationTypeEnum {
    INTERNAL("Internal"),
    INDIVIDUAL("Individual"),
    GROUP("Group"),
    ;

    private final String type;

    private static final Logger logger = LoggerFactory.getLogger(OrganizationTypeEnum.class);

    public static OrganizationTypeEnum fromType(String type) {
        for (OrganizationTypeEnum orgType : OrganizationTypeEnum.values()) {
            if (orgType.getType().equalsIgnoreCase(type)) {
                return orgType;
            }
        }
        logger.error("Unknown Organization Type: {}", type);
        throw new IllegalArgumentException();
    }
}

