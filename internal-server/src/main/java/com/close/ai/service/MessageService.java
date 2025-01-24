package com.close.ai.service;

import com.close.ai.dto.converter.MessageDTOConverter;
import com.close.ai.mapper.MessageMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class MessageService {
    private final MessageMapper messageMapper;

    private final MessageDTOConverter messageDTOConverter;

    public MessageService(MessageMapper messageMapper,
                          MessageDTOConverter messageDTOConverter) {
        this.messageMapper = messageMapper;
        this.messageDTOConverter = messageDTOConverter;
    }
}
