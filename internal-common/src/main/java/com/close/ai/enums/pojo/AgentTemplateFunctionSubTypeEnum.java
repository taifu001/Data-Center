package com.close.ai.enums.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-1-22
 */
@Getter
@AllArgsConstructor
public enum AgentTemplateFunctionSubTypeEnum {
    VOICE_TO_TEXT("voiceToText"),
    VOICE_TO_VOICE("voiceToVoice"),
    TEXT_TO_VOICE("textToVoice"),
    TEXT_TO_IMAGE("textToImage"),
    CHAT("chat"),
    OTHER("other"),
    UNDEFINED("undefined")
    ;
    private final String functionSubType;


}
