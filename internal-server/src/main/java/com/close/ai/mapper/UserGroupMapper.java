package com.close.ai.mapper;

import com.close.ai.pojo.UserGroup;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface UserGroupMapper {
    Integer insertUserGroup(UserGroup userGroup);

    Integer deleteUserGroup(UserGroup userGroup);
}
