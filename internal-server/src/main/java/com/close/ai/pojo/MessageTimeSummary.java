package com.close.ai.pojo;

import com.close.ai.enums.pojo.MessageSummaryTypeEnum;
import com.close.ai.enums.pojo.TimeTypeEnum;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-1-21
 */
@Data
public class MessageTimeSummary {
    private Long id;
    // 来源类型
    private MessageSummaryTypeEnum sourceType;
    // 来源ID
    private Long sourceId;
    // 消息ID列表
    private String messages;
    // 消息内容摘要
    private String summaryText;
    // 文件ID列表
    private String summaryFiles;
    // 时间粒度
    private TimeTypeEnum timeType;

    private String timeStr;
}
