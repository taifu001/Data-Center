package com.close.ai.dto.converter;

import com.close.ai.dto.MessageDTO;
import com.close.ai.pojo.Message;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface MessageDTOConverter {
    MessageDTO fromEntity(Message message);

    Message toEntity(MessageDTO messageDTO);
}
