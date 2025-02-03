package com.close.ai.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HumanPersonaConversationDTO {
    private Long id;
    private Long humanId;
    private Long personaId;
    private List<Long> messages;
    private Boolean isGroup;
    private Long groupId;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
