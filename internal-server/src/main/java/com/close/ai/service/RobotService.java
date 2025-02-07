package com.close.ai.service;

import com.close.ai.dto.converter.RobotDTOConverter;
import com.close.ai.mapper.RobotMapper;
import com.close.ai.pojo.Robot;
import com.close.ai.request.create.RobotCreateRequest;
import com.close.ai.utils.IdUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Service
public class RobotService {
    private final RobotMapper robotMapper;

    private final RobotDTOConverter robotDTOConverter;

    private static final Set<Integer> VALID_STATES = Set.of(0, 1);

    public RobotService(RobotMapper robotMapper,
                        RobotDTOConverter robotDTOConverter) {
        this.robotMapper = robotMapper;
        this.robotDTOConverter = robotDTOConverter;
    }

    @Transactional
    public void createRobot(RobotCreateRequest request) {
        if (request == null || request.getProductId() == null ||
                request.getOwnerType() == null || request.getOwnerId() == null) {
            throw new IllegalArgumentException("Request parameters cannot be null");
        }

        Robot robot = robotDTOConverter.toEntity(request.toDTO());
        robot.setId(IdUtil.getSnowflake().nextId());

        if (robot.getState() == null) {
            robot.setState(0);
        } else if (!VALID_STATES.contains(robot.getState())) {
            throw new IllegalStateException("Invalid robot state: " + robot.getState());
        }

        Integer res = robotMapper.insertRobot(robot);
        if (res != 1) {
            throw new RuntimeException("Failed to insert robot into database");
        }
    }
}
