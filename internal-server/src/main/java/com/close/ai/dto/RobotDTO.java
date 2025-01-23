package com.close.ai.dto;

import com.close.ai.enums.pojo.OwnerTypeEnum;
import com.close.ai.pojo.Robot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RobotDTO {
    private Long id;
    private Long productId;
    private String name;
    private String version;
    private String introduction;
    private Integer state;
    private OwnerTypeEnum ownerType;
    private Long ownerId;
    private Boolean isOnlyForInternal;

    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public static RobotDTO fromEntity(Robot robot) {
        RobotDTO dto = new RobotDTO();
        dto.id = robot.getId();
        dto.productId = robot.getProductId();
        dto.name = robot.getName();
        dto.version = robot.getVersion();
        dto.introduction = robot.getIntroduction();
        dto.state = robot.getState();
        dto.ownerType = robot.getOwnerType();
        dto.ownerId = robot.getOwnerId();
        dto.isOnlyForInternal = robot.getIsOnlyForInternal();
        dto.createdTime = robot.getCreatedTime();
        dto.updatedTime = robot.getUpdatedTime();
        return dto;
    }

    public static Robot toEntity(RobotDTO dto) {
        Robot robot = new Robot();
        robot.setId(dto.getId());
        robot.setProductId(dto.getProductId());
        robot.setName(dto.getName());
        robot.setVersion(dto.getVersion());
        robot.setIntroduction(dto.getIntroduction());
        robot.setState(dto.getState());
        robot.setOwnerType(dto.getOwnerType());
        robot.setOwnerId(dto.getOwnerId());
        robot.setIsOnlyForInternal(dto.getIsOnlyForInternal());
        return robot;
    }
}
