package com.close.ai.service;

import com.close.ai.enums.ResponseCode;
import com.close.ai.mapper.RobotAgentMapper;
import com.close.ai.pojo.RobotAgent;
import org.springframework.stereotype.Service;

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

    public ResponseCode createRobotAgent(Long robotId, Long agentId) {
        if (robotId == null || agentId == null) {
            return ResponseCode.PARAMETER_NULL;
        }
        RobotAgent robotAgent = new RobotAgent();
        robotAgent.setRobotId(robotId);
        robotAgent.setAgentId(agentId);
        Integer res = robotAgentMapper.insertRobotAgent(robotAgent);
        if (res != 1) {return ResponseCode.RELATIONSHIP_TABLE_INSERT_FAILED;}
        return ResponseCode.OK;
    }
}
