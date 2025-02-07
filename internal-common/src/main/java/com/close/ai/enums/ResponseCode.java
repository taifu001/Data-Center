package com.close.ai.enums;

import lombok.Getter;

/**
 * @author nbwyctf
 * @since 2025-01-19
 */
@Getter
public enum ResponseCode {
    /**
     * 通用错误
     */
    OK(200, "success"),
    NO_AUTHORIZATION(4001,"无权限"),

    SERVER_INTERNAL_ERROR(500, "服务器异常"),
    REQUEST_ERROR(50001,"请求错误"),
    SEVER_INTERNAL_FUNCTION_TO_BE_IMPLEMENTED(50002, "服务器内部功能待实现"),
    PARAMETER_NULL(50003, "参数为空"),
    RELATIONSHIP_TABLE_INSERT_FAILED(50005, "插入关系表失败"),
    SOURCE_TYPE_ERROR(50005, "来源类型错误"),

    ORGANIZATION_NOT_EXIST(10001001, "组织不存在"),

    USER_NOT_EXIST(10002001, "用户不存在"),
    USER_INFORMATION_IS_REPEAT(10002002, "用户信息重复"),
    USER_EMAIL_IS_INVALID(10002003, "用户邮箱无效"),
    USER_PHONE_IS_INVALID(10002004, "用户手机号无效"),

    USER_INSERT_FAILED(100020010, "用户插入失败"),

    GROUP_NOT_EXIST(10003001, "组不存在"),
    ;

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
