package com.close.ai.service;

import com.close.ai.dto.RobotDTO;
import com.close.ai.dto.converter.RobotDTOConverter;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.RobotMapper;
import com.close.ai.pojo.Robot;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class RobotService {
    private final RobotMapper robotMapper;

    private final RobotDTOConverter robotDTOConverter;

    public RobotService(RobotMapper robotMapper,
                        RobotDTOConverter robotDTOConverter) {
        this.robotMapper = robotMapper;
        this.robotDTOConverter = robotDTOConverter;
    }

    public ResponseCode createRobot(RobotDTO robotDTO) {
        if (robotDTO == null || robotDTO.getProductId() == null ||
                robotDTO.getOwnerType() == null || robotDTO.getOwnerId() == null) {
            return ResponseCode.PARAMETER_NULL;
        }

        Robot robot = robotDTOConverter.toEntity(robotDTO);
        robot.setId(IdUtil.getSnowflake().nextId());
        Integer res = robotMapper.insertRobot(robot);
        if (res != 1) {return ResponseCode.ROBOT_INSERT_ERROR;}
        return ResponseCode.OK;
    }
}
