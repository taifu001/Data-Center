package com.close.ai.request.create;

import com.close.ai.dto.PersonaDTO;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Data
public class PersonaCreateRequest {
    private Long agentId;
    // 人格状态 0:正常 1:失效
    private Integer state;
    private String traitsJson;

    public PersonaDTO toDTO() {
        return PersonaDTO.builder()
                .agentId(agentId)
                .state(state)
                .traitsJson(traitsJson)
                .build();
    }
}
