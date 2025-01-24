package com.close.ai.dto;

import com.close.ai.enums.pojo.ConversationEndpointTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationDTO {
    private Long id;
    private Integer state;
    private ConversationEndpointTypeEnum fromType;
    private Long fromId;
    private ConversationEndpointTypeEnum toType;
    private Long toId;
    private Boolean isGroup;
    private Long groupId;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
