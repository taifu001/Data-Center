package com.close.ai.service;

import com.close.ai.dto.converter.ConversationDTOConverter;
import com.close.ai.mapper.ConversationMapper;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Service
public class ConversationService {
    final private ConversationMapper conversationMapper;

    final private ConversationDTOConverter conversationDTOConverter;

    public ConversationService(ConversationMapper conversationMapper, ConversationDTOConverter conversationDTOConverter) {
        this.conversationMapper = conversationMapper;
        this.conversationDTOConverter = conversationDTOConverter;
    }
}
