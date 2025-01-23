package com.close.ai.mapper;

import com.close.ai.pojo.Tool;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author taifu
 * @since 2025-01-20
 */
@Mapper
public interface ToolMapper {
    Tool selectToolById(@Param("id") Long id);

    Integer insertTool(Tool tool);

    Integer updateTool(Tool tool);
}
