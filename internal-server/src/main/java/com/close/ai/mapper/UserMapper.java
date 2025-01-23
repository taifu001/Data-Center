package com.close.ai.mapper;

import com.close.ai.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ctf
 * @since 2025-01-20
 */
@Mapper
public interface UserMapper {
    Integer insertUser(User user);

    Integer deregisterAccount(@Param("id") Long id);

    User selectUserById(@Param("id") Long id);

    User selectActiveUserById(@Param("id") Long id);

    User selectActiveUserByEmail(@Param("email") String email);

    User selectActiveUserByPhone(@Param("phonePrefix") String phonePrefix,
                                 @Param("phoneNumber") String phoneNumber);

    // 检查用户邮箱和手机号是否重复
    List<Long> checkForDuplicateInformationBeforeCreating(@Param("email") String email,
                                                          @Param("phonePrefix") String phonePrefix,
                                                          @Param("phoneNumber") String phoneNumber);

    List<User> fuzzySelectActiveUserByEmail(@Param("email") String email);

    void updateUserById(User user);

    void updateUserByEmail(User user);


}


