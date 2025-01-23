package com.close.ai.pojo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-1-21
 */
@Data
public class Human {
    private Long id;

    /** 关联的用户ID(若有) */
    private Long userId;

    /** 人物名称 */
    private String name;

    /** 性别 0:女 1:男 */
    private Integer gender;

    /** 出生日期 */
    private LocalDate birthday;

    /** 人物特征 */
    private String traitsJson;

    /** 人物状态 0:正常 1:失效 */
    private Integer state;

    /** 记录创建时间 */
    private LocalDateTime createdTime;

    /** 记录最后更新时间 */
    private LocalDateTime updatedTime;
}
