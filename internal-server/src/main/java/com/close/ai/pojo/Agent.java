package com.close.ai.pojo;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author nbwyctf
 * @since 2025-01-22
 */
@Data
public class Agent {
    private Long id;
    private Long agentTemplateId;
    private String name;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;
    private Integer state;

    private LocalDate birthday;
}
