package com.close.ai.request.update;

import com.close.ai.dto.PersonaDTO;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class PersonaUpdateRequest {
    private Long id;
    /** 人格状态 0:正常 1:失效 */
    private Integer state;
    private String traitsJson;

    public PersonaDTO toDTO() {
        return PersonaDTO.builder()
                .id(id)
                .state(state)
                .traitsJson(traitsJson)
                .build();
    }
}
