package com.close.ai.request.create;

import com.close.ai.dto.HumanPersonaConversationDTO;
import lombok.Data;

import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-02-03
 */
@Data
public class HumanPersonaConversationSaveRequest {
    private Long humanId;
    private Long personaId;
    private List<MessageSaveRequest> messages;
    private Boolean isGroup;
    private Long groupId;

    public HumanPersonaConversationDTO toDTO() {
        return HumanPersonaConversationDTO.builder()
                .humanId(this.humanId)
                .personaId(this.personaId)
                .isGroup(this.isGroup)
                .groupId(this.groupId)
                .build();
    }
}
