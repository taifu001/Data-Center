package com.close.ai.mapper;

import com.close.ai.pojo.File;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Mapper
public interface FileMapper {
    File selectFileById(@Param("id") Long id);

    Integer insertFile(File file);
}
