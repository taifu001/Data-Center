package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author taifu
 * @since 2025-1-22
 */
@Getter
@AllArgsConstructor
public enum HumanRelationshipTypeEnum {
    // question 是否需要将FATHER和MOTHER合并为PARENT（同理还有SON和DAUGHTER）,因为Human有gender参数
    FATHER("father"),
    MOTHER("mother"),
    TEACHER("teacher"),
    SPOUSE("spouse"),
    SON("son"),
    DAUGHTER("daughter"),
    SISTER("sister"),
    BROTHER("brother"),
    FRIEND("friend"),
    COWORKER("coworker"),
    OTHER("other")
    ;
    private final String humanRelationshipType;
}
