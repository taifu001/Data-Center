package com.close.ai.dto;

import com.close.ai.enums.pojo.MessageTypeEnum;
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
public class MessageDTO {
    private Long id;
    private Long conversationId;
    private MessageTypeEnum messageType;
    private String textContent;
    private Long fileId;
    private String storagePath;
    // todo 情绪态度指数字段

    private LocalDateTime sentTime;
}
