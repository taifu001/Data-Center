package com.close.ai.mapper;

import com.close.ai.pojo.RobotAgent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface RobotAgentMapper {
    Integer insertRobotAgent(RobotAgent robotAgent);

    Integer deleteRobotAgent(RobotAgent robotAgent);
}
