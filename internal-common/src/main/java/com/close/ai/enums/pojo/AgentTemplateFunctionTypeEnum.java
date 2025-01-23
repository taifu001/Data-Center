package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-1-22
 */
@Getter
@AllArgsConstructor
public enum AgentTemplateFunctionTypeEnum {
    VOICE("voice"),
    TEXT("text"),
    CHAT("chat"),
    FUNCTION("function"),
    OTHER("other"),
    ;

    private final String functionType;

}
