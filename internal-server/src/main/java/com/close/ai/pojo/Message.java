package com.close.ai.pojo;

import com.close.ai.enums.pojo.MessageTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-21
 */
@Data
public class Message {
    private Long id;
    private Long conversationId;
    private MessageTypeEnum messageType;
    private String textContent;
    private Long fileId;
    private String storagePath;
    // todo 情绪态度指数字段

    private LocalDateTime sentTime;
}
