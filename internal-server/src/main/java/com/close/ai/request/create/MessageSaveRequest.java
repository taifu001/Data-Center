package com.close.ai.request.create;

import com.close.ai.dto.MessageDTO;
import com.close.ai.enums.pojo.MessageEndpointTypeEnum;
import com.close.ai.enums.pojo.MessageInteractionType;
import com.close.ai.enums.pojo.MessageTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-02-03
 */
@Data
public class MessageSaveRequest {
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

    private LocalDateTime sentTime;

    public MessageDTO toDTO() {
        return MessageDTO.builder()
                .messageType(this.messageType)
                .interactionType(this.interactionType)
                .textContent(this.textContent)
                .state(this.state)
                .fromType(this.fromType)
                .fromId(this.fromId)
                .toType(this.toType)
                .toId(this.toId)
                .fileId(this.fileId)
                .isGroup(this.isGroup)
                .groupId(this.groupId)
                .sentTime(this.sentTime)
                .build();
    }
}
