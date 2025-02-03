package com.close.ai.request.create;

import com.close.ai.dto.PersonaDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Data
public class PersonaCreateRequest {
    private Long agentId;
    // 人格状态 0:正常 1:失效
    private Integer state;
    // 人格回复使用的语言
    private String language;
    private String traitsJson;

    public PersonaDTO toDTO() {
        return PersonaDTO.builder()
                .agentId(agentId)
                .state(state)
                .language(language)
                .traitsJson(traitsJson)
                .build();
    }
}
