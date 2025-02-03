package com.close.ai.pojo;

import com.close.ai.enums.pojo.MessageEndpointTypeEnum;
import com.close.ai.enums.pojo.MessageInteractionType;
import com.close.ai.enums.pojo.MessageTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Data
public class Message {
    private Long id;
    private MessageTypeEnum messageType;
    private MessageInteractionType interactionType;
    private String textContent;

    private Integer state;
    private MessageEndpointTypeEnum fromType;
    private Long fromId;
    private MessageEndpointTypeEnum toType;
    private Long toId;

    private Long fileId;

    private Boolean isGroup;
    private Long groupId;

    // todo 情绪态度指数字段

    private LocalDateTime sentTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
