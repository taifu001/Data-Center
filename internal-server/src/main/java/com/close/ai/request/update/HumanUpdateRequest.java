package com.close.ai.request.update;

import com.close.ai.dto.HumanDTO;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author nbwyctf
 * @since 2025-02-05
 */
@Data
public class HumanUpdateRequest {
    private Long id;

    private String name;
    private Integer gender;
    private LocalDate birthday;
    private String traitsJson;
    /** 人物状态 0:正常 1:失效 */
    private Integer state;

    public HumanDTO toDTO() {
        return HumanDTO.builder()
                .id(id)
                .name(name)
                .gender(gender)
                .birthday(birthday)
                .traitsJson(traitsJson)
                .state(state)
                .build();
    }
}
