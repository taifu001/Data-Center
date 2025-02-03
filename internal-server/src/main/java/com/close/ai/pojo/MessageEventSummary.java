package com.close.ai.pojo;

import com.close.ai.enums.pojo.MessageSummaryTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Data
public class MessageEventSummary {
    private Long id;
    private MessageSummaryTypeEnum sourceType;
    private Long sourceId;
    private String messages;
    private String summaryText;
    // 文件ID列表
    private String summaryFiles;
    private String tags;

    private LocalDateTime firstMessageTime;
    private LocalDateTime lastMessageTime;
}
