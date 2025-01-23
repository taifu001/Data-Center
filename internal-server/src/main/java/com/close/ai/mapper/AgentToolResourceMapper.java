package com.close.ai.mapper;

import com.close.ai.pojo.AgentToolResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author nbwyctf
 * @since 2025-01-23
 */
@Mapper
public interface AgentToolResourceMapper {
    Integer insertAgentToolResource(AgentToolResource agentToolResource);

    Integer deleteAgentToolResource(AgentToolResource agentToolResource);
}
