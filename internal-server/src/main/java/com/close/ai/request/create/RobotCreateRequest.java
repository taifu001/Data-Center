package com.close.ai.request.create;

import com.close.ai.dto.RobotDTO;
import com.close.ai.enums.pojo.OwnerTypeEnum;
import lombok.Data;

/**
 * @author nbwyctf
 * @since 2025-1-25
 */
@Data
public class RobotCreateRequest {
    private Long productId;
    private String name;
    private String introduction;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;

    public RobotDTO toDTO(){
        return RobotDTO.builder()
                .productId(productId)
                .name(name)
                .introduction(introduction)
                .ownerType(ownerType)
                .ownerId(ownerId)
                .isOnlyForInternal(isOnlyForInternal)
                .build();
    }
}
