package com.close.ai.mapper;

import com.close.ai.pojo.Agent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taifu
 * @since 2025-01-22
 */
@Mapper
public interface AgentMapper {
    Agent selectAgentById(@Param("id") Long id);

    List<Agent> selectActiveAgentsByOwner(@Param("ownerType") Integer ownerType,
                                          @Param("ownerId") Long ownerId);

    Integer insertAgent(Agent agent);

    Integer updateAgent(Agent agent);
}
