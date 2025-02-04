package com.close.ai.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-02-04
 */
@Data
public class HumanPersonaConversationMessagesDTO {
    private Long id;
    private Long humanId;
    private Long personaId;
    private List<MessageDTO> messages;
    private Boolean isGroup;
    private Long groupId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
