package com.close.ai.service;

import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.RobotAgentMapper;
import com.close.ai.pojo.RobotAgent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nbwyctf
 * @since 2025-02-03
 */
@Service
public class RobotAgentService {
    private final RobotAgentMapper robotAgentMapper;

    public RobotAgentService(RobotAgentMapper robotAgentMapper) {
        this.robotAgentMapper = robotAgentMapper;
    }

    public void createRobotAgent(Long robotId, Long agentId) {
        if (robotId == null || agentId == null) {
            throw new IllegalArgumentException("Robot ID and Agent ID cannot be null");
        }

        RobotAgent robotAgent = new RobotAgent();
        robotAgent.setRobotId(robotId);
        robotAgent.setAgentId(agentId);

        int res = robotAgentMapper.insertRobotAgent(robotAgent);
        if (res != 1) {
            throw new RuntimeException("Failed to insert robot-agent relationship");
        }
    }
}
