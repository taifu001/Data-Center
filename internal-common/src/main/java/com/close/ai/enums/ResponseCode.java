package com.close.ai.enums;

import lombok.Getter;

/**
 * @author taifu
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

    ORGANIZATION_NAME_IS_EMPTY(10001001, "组织名字为空"),
    ORGANIZATION_NAME_IS_REPEAT(10001002, "组织名字重复"),
    ORGANIZATION_NOT_EXIST(10001003, "组织不存在"),
    USER_INFORMATION_IS_REPEAT(10002001, "用户信息重复"),
    USER_EMAIL_IS_INVALID(10002002, "用户邮箱无效"),
    USER_PHONE_IS_INVALID(10002003, "用户手机号无效"),

    USER_INSERT_ERROR(100020010, "用户插入失败"),

    HUMAN_INSERT_ERROR(10005010, "人物插入失败"),

    PRODUCT_NAME_IS_REPEAT(100006001, "产品名字重复"),
    PRODUCT_INSERT_ERROR(100006010, "产品插入失败"),
    PRODUCT_UPDATE_ERROR(100006011, "产品更新失败"),
    PRODUCT_RELEASE_ERROR(100006012, "产品发布失败"),
    ;

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
