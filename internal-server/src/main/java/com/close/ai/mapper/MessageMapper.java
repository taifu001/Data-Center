package com.close.ai.mapper;

import com.close.ai.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Mapper
public interface MessageMapper {
    Message selectMessageById(@Param("id") Long id);

    Integer insertMessage(Message message);
}
