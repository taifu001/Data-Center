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
    DATA_STATUS_INSERT_FAILED(50004, "插入数据状态错误"),
    RELATIONSHIP_TABLE_INSERT_FAILED(50005, "插入关系表失败"),
    SOURCE_TYPE_ERROR(50005, "来源类型错误"),

    ORGANIZATION_NOT_EXIST(10001001, "组织不存在"),
    ORGANIZATION_NAME_IS_EMPTY(10001002, "组织名字为空"),
    ORGANIZATION_NAME_IS_REPEAT(10001003, "组织名字重复"),

    USER_NOT_EXIST(10002001, "用户不存在"),
    USER_INFORMATION_IS_REPEAT(10002002, "用户信息重复"),
    USER_EMAIL_IS_INVALID(10002003, "用户邮箱无效"),
    USER_PHONE_IS_INVALID(10002004, "用户手机号无效"),

    USER_INSERT_FAILED(100020010, "用户插入失败"),

    GROUP_NOT_EXIST(10003001, "组不存在"),

    HUMAN_NOT_EXIST(10005001, "人物不存在"),
    HUMAN_INSERT_FAILED(10005010, "人物插入失败"),

    PRODUCT_NAME_IS_REPEAT(100006001, "产品名字重复"),
    PRODUCT_INSERT_FAILED(100006010, "产品插入失败"),
    PRODUCT_UPDATE_FAILED(100006011, "产品更新失败"),
    PRODUCT_RELEASE_FAILED(100006012, "产品发布失败"),

    ROBOT_INSERT_FAILED(100007010, "产品实例插入失败"),

    AGENT_TEMPLATE_NOT_EXIST(100008001, "智能体模板不存在"),
    AGENT_TEMPLATE_INSERT_FAILED(100008010, "智能体模板插入失败"),

    AGENT_NOT_EXIST(100009001, "智能体不存在"),
    AGENT_INSERT_FAILED(100009010, "智能体插入失败"),

    PERSONA_NOT_EXIST(100010001, "人格不存在"),
    PERSONA_INSERT_FAILED(100010010, "人格插入失败"),

    MESSAGE_INSERT_FAILED(100011010, "消息插入失败"),

    HUMAN_PERSONA_CONVERSATION_INSERT_FAILED(100012010, "人物人格对话插入失败"),
    ;

    private final int code;
    private final String message;

    ResponseCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
