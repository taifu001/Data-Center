package com.close.ai.dto.converter;

import com.close.ai.dto.RobotDTO;
import com.close.ai.pojo.Robot;
import org.mapstruct.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-24
 */
@Mapper(componentModel = "spring")
public interface RobotDTOConverter {
    RobotDTO fromEntity(Robot robot);

    Robot toEntity(RobotDTO robotDTO);
}
