package com.close.ai.service;

import com.close.ai.dto.UserDTO;
import com.close.ai.dto.converter.UserDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.UserMapper;
import com.close.ai.pojo.User;
import com.close.ai.utils.IdUtil;
import com.close.ai.utils.PasswordUtil;
import com.close.ai.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Service
public class UserService {
    private final UserMapper userMapper;

    private final HumanService humanService;
    private final OrganizationService organizationService;

    private final UserDTOConverter userDTOConverter;

    @Autowired
    public UserService(UserMapper userMapper,
                       HumanService humanService,
                       OrganizationService organizationService,
                       UserDTOConverter userDTOConverter) {
        this.userMapper = userMapper;
        this.humanService = humanService;
        this.organizationService = organizationService;
        this.userDTOConverter = userDTOConverter;
    }


    /**
     * 根据id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    public UserDTO getUserById(Long id, boolean isActive) {
        if (id == null) {
            return null;
        }
        User user = isActive
                ? userMapper.selectActiveUserById(id)
                : userMapper.selectUserById(id);
        if(user == null){
            return null;
        }
        return userDTOConverter.fromEntity(user);
    }

    /**
     * 根据邮箱获取正常用户信息
     *
     * @param email 用户邮箱
     * @return 用户信息
     */
    public UserDTO getActiveUserByEmail(String email) {
        if (!ValidationUtil.isValidEmail(email)) {
            return null;
        }
        User user = userMapper.selectActiveUserByEmail(email);
        if(user == null){
            return null;
        }
        return userDTOConverter.fromEntity(user);
    }

    public ResponseCode checkUserDtoBeforeCreateUser(UserDTO userDTO){
        if(userDTO == null || userDTO.getPassword() == null){
            return ResponseCode.PARAMETER_NULL;
        }
        String email = userDTO.getEmail();
        String phonePrefix = userDTO.getPhonePrefix();
        String phoneNumber = userDTO.getPhoneNumber();
        if(!ValidationUtil.isValidEmail(email)){
            return ResponseCode.USER_EMAIL_IS_INVALID;
        }
        if (!ValidationUtil.isValidPhone(phonePrefix, phoneNumber)) {
            return ResponseCode.USER_PHONE_IS_INVALID;
        }
        // 判断是否存在重复信息(邮箱和手机号)
        List<Long> ids = userMapper.checkForDuplicateInformationBeforeCreating(email, phonePrefix, phoneNumber);
        if (ids != null && !ids.isEmpty()) {
            return ResponseCode.USER_INFORMATION_IS_REPEAT;
        }
        return ResponseCode.OK;
    }

    /**
     * 创建个人用户
     * @param userDTO 用户信息
     * @param createBlankHuman 是否创建空白人物
     * @return 响应码
     */
    public ResponseCode createRegularUser(UserDTO userDTO,
                                          Boolean createBlankHuman) {
        ResponseCode code = checkUserDtoBeforeCreateUser(userDTO);
        if(code != ResponseCode.OK){
            return code;
        }

        User user = userDTOConverter.toEntity(userDTO);
        user.setId(IdUtil.getSnowflake().nextId());
        user.setOrganizationId(organizationService.getOrganizationId("REGULAR USER"));
        // 密码加密
        String hashedPassword = PasswordUtil.hashPassword(userDTO.getPassword());
        user.setPassword(hashedPassword);
        Integer res = userMapper.insertUser(user);
        if (res != 1) {
            return ResponseCode.USER_INSERT_ERROR;
        }
        if (createBlankHuman) {
            humanService.createBlankHumanWithUserId(user.getId());
        }
        return ResponseCode.OK;
    }

    // 暂时用于测试
    public ResponseCode createSystemUser(UserDTO userDTO,
                                         Boolean createBlankHuman){
        ResponseCode code = checkUserDtoBeforeCreateUser(userDTO);
        if(code != ResponseCode.OK){
            return code;
        }

        User user = userDTOConverter.toEntity(userDTO);
        user.setId(IdUtil.getSnowflake().nextId());
        user.setOrganizationId(organizationService.getOrganizationId("SYSTEM"));
        // 密码加密
        String hashedPassword = PasswordUtil.hashPassword(userDTO.getPassword());
        user.setPassword(hashedPassword);
        Integer res = userMapper.insertUser(user);
        if (res != 1) {
            return ResponseCode.USER_INSERT_ERROR;
        }
        if (createBlankHuman) {
            humanService.createBlankHumanWithUserId(user.getId());
        }
        return ResponseCode.OK;
    }

}
