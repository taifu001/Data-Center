package com.close.ai.dto.converter;

import com.close.ai.dto.HumanPersonaConversationDTO;
import com.close.ai.pojo.HumanPersonaConversation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface HumanPersonaConversationDTOConverter {

    @Mapping(target = "messages",
            expression = "java(com.close.ai.utils.JacksonUtil.parseJsonToList(conversation.getMessages(), Long.class))")
    HumanPersonaConversationDTO fromEntity(HumanPersonaConversation conversation);

    @Mapping(target = "messages",
            expression = "java(com.close.ai.utils.JacksonUtil.listToJson(dto.getMessages()))")
    HumanPersonaConversation toEntity(HumanPersonaConversationDTO dto);
}
