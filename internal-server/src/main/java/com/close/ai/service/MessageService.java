package com.close.ai.service;

import com.close.ai.dto.MessageDTO;
import com.close.ai.dto.converter.MessageDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.MessageMapper;
import com.close.ai.pojo.Message;
import com.close.ai.request.create.MessageSaveRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class MessageService {
    private final MessageMapper messageMapper;

    private final MessageDTOConverter messageDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1);

    public MessageService(MessageMapper messageMapper,
                          MessageDTOConverter messageDTOConverter) {
        this.messageMapper = messageMapper;
        this.messageDTOConverter = messageDTOConverter;
    }

    /**
     * 批量保存消息，并返回插入的消息IDs
     * @param requests 请求
     * @return 响应码
     */
    @Transactional
    public List<Long> saveMessages(List<MessageSaveRequest> requests) {
        if (requests == null || requests.isEmpty()) {
            throw new IllegalArgumentException("Request list cannot be empty");
        }

        List<Message> messages = requests.stream()
                .map(request -> {
                    Message message = messageDTOConverter.toEntity(request.toDTO());
                    message.setId(IdUtil.getSnowflake().nextId()); // 生成唯一 ID
                    if (message.getState() == null) {
                        message.setState(0);
                    } else if (!VALID_STATES.contains(message.getState())) {
                        throw new IllegalArgumentException("Invalid message state");
                    }
                    return message;
                }).collect(Collectors.toList());

        // 批量插入数据库
        Integer res = messageMapper.batchInsertMessages(messages);
        if (res != messages.size()) {
            throw new RuntimeException("Batch message insertion failed");
        }

        // 收集插入后的消息 ID
        return messages.stream().map(Message::getId).toList();
    }

    @Transactional
    public Long saveMessage(MessageSaveRequest request) {
        // 参数校验
        if (request == null || request.getMessageType() == null || request.getInteractionType() == null ||
                request.getTextContent() == null || request.getSentTime() == null) {
            throw new IllegalArgumentException("Invalid message parameters");
        }

        // 转换为 Message 实体
        Message message = messageDTOConverter.toEntity(request.toDTO());

        // 生成唯一 ID
        Long generatedId = IdUtil.getSnowflake().nextId();
        message.setId(generatedId);

        // 设置默认状态
        if (message.getState() == null) {
            message.setState(0);
        } else if (!VALID_STATES.contains(message.getState())) {
            throw new IllegalArgumentException("Invalid message state");
        }

        // 执行数据库插入
        Integer res = messageMapper.insertMessage(message);
        if (res != 1) {
            throw new RuntimeException("Message insertion failed");
        }

        // 返回插入的消息 ID
        return generatedId;
    }

}
