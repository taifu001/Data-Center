package com.close.ai.dto.converter;

import com.close.ai.dto.ConversationDTO;
import com.close.ai.pojo.Conversation;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface ConversationDTOConverter {
    ConversationDTO fromEntity(Conversation conversation);

    Conversation toEntity(ConversationDTO dto);
}
