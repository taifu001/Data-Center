package com.close.ai.mapper;

import com.close.ai.dto.HumanPersonaConversationMessagesDTO;
import com.close.ai.pojo.HumanPersonaConversation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface HumanPersonaConversationMapper {
    HumanPersonaConversation selectHumanPersonaConversationById(@Param("id") Long id);

    List<HumanPersonaConversationMessagesDTO> selectHumanPersonaConversationMessages(HumanPersonaConversation conversation);

    Integer insertHumanPersonaConversation(HumanPersonaConversation conversation);

    Integer updateHumanPersonaConversation(HumanPersonaConversation conversation);
}
