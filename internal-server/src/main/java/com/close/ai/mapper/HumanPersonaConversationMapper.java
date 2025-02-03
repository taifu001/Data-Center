package com.close.ai.mapper;

import com.close.ai.pojo.HumanPersonaConversation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface HumanPersonaConversationMapper {
    HumanPersonaConversation selectHumanPersonaConversationById(@Param("id") Long id);

    Integer insertHumanPersonaConversation(HumanPersonaConversation conversation);

    Integer updateHumanPersonaConversation(HumanPersonaConversation conversation);
}
