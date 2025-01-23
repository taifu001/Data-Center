package com.close.ai.mapper;

import com.close.ai.pojo.Human;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nbwyctf
 * @since 2025-01-21
 */
@Mapper
public interface HumanMapper {
    Human selectHumanById(@Param("id") Long id);

    Human selectActiveHumanById(@Param("id") Long id);

    // 只支持一个user对应一个human
    Human selectActiveHumanByUserId(@Param("id") Long userId);

    Integer insertHuman(Human human);

    Integer updateHumanById(Human human);

    Integer updateHumanByUserId(Human human);

    // Integer deleteHumanById(Long id);
}
