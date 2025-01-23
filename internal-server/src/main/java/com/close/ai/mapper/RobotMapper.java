package com.close.ai.mapper;

import com.close.ai.pojo.Robot;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author taifu
 * @since 2025-01-23
 */
@Mapper
public interface RobotMapper {
    Robot selectRobotById(@Param("id") Long id);

    Integer insertRobot(Robot robot);

    Integer updateRobot(Robot robot);
}
