package com.close.ai.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-02
 */
@Data
public class HumanPersonaConversation {
    private Long id;
    private Long humanId;
    private Long personaId;
    private String messages;
    private Boolean isGroup;
    private Long groupId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
