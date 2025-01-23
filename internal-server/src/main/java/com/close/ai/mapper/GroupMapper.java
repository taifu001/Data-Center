package com.close.ai.mapper;

import com.close.ai.pojo.Group;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface GroupMapper {
    Group selectGroupById(@Param("id") Long id);

    Integer insertGroup(Group group);

    Integer updateGroup(Group group);
}
