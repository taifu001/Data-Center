package com.close.ai.service;

import com.close.ai.dto.RobotDTO;
import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.RobotMapper;
import org.springframework.stereotype.Service;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Service
public class RobotService {
    private final RobotMapper robotMapper;

    public RobotService(RobotMapper robotMapper) {
        this.robotMapper = robotMapper;
    }

    public ResponseCode createRobot(RobotDTO robotDTO) {
//        if (robotDTO == null || robotDTO.) {
//            return ResponseCode.PARAMETER_NULL;
//        }

//        Robot robot = RobotDTO.toEntity(robotDTO);
//        Integer result = robotMapper.insertRobot(robot);
//        if (result > 0) {
//            return ResponseCode.OK;
//        }
//        return ResponseCode.SERVER_INTERNAL_ERROR;
        return ResponseCode.OK;
    }
}
