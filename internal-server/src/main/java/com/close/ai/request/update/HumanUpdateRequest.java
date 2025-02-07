package com.close.ai.request.update;

import com.close.ai.dto.HumanDTO;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class HumanUpdateRequest {
    private Long id;
    /** 人物状态 0:正常 1:失效 */
    private Integer state;
    private String traitsJson;

    public HumanDTO toDTO() {
        return HumanDTO.builder()
                .id(id)
                .traitsJson(traitsJson)
                .state(state)
                .build();
    }
}
