package com.close.ai.mapper;

import com.close.ai.pojo.Conversation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Mapper
public interface ConversationMapper {
    Conversation selectConversationById(@Param("id") Long id);

    Integer insertConversation(Conversation conversation);

    Integer updateConversationById(Conversation conversation);
}
