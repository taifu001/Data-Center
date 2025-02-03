package com.close.ai.request.create;

import com.close.ai.dto.AgentDTO;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Data
public class AgentCreateRequest {
    private Long agentTemplateId;
    private Long robotId;
    private String name;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;
    private Integer state;

    private LocalDate birthday;

    public AgentDTO toDTO() {
        return AgentDTO.builder()
                .agentTemplateId(agentTemplateId)
                .name(name)
                .ownerType(ownerType)
                .ownerId(ownerId)
                .isOnlyForInternal(isOnlyForInternal)
                .state(state)
                .birthday(birthday)
                .build();
    }
}
