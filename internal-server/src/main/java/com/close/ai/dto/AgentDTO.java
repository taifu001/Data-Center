package com.close.ai.dto;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AgentDTO {
    private Long id;
    private Long agentTemplateId;
    private String name;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;
    private Integer state;

    private LocalDate birthday;
}
