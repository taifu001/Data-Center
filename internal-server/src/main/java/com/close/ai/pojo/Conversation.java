package com.close.ai.pojo;

import com.close.ai.enums.pojo.ConversationEndpointTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-21
 */
@Data
public class Conversation {
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

